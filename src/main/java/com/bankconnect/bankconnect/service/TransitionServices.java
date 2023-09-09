package com.bankconnect.bankconnect.service;

import com.bankconnect.bankconnect.dto.TransitionDto;
import com.bankconnect.bankconnect.model.Client;
import com.bankconnect.bankconnect.model.Company;
import com.bankconnect.bankconnect.model.Transition;
import com.bankconnect.bankconnect.model.TypeTransition;
import com.bankconnect.bankconnect.repository.ClientRepository;
import com.bankconnect.bankconnect.repository.CompanyRepository;
import com.bankconnect.bankconnect.repository.TransitionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TransitionServices {
    private final TransitionRepository transitionRepository;
    private final ClientRepository clientRepository;
    private final CompanyRepository companyRepository;

    public TransitionServices(TransitionRepository transitionRepository, ClientRepository clientRepository, CompanyRepository companyRepository) {
        this.transitionRepository = transitionRepository;
        this.clientRepository = clientRepository;
        this.companyRepository = companyRepository;
    }

    private Transition performTransaction(TypeTransition type, TransitionDto transactionDto, long id) throws Exception {
        Client client = clientRepository.findById(id).orElseThrow(() -> new Exception("Cliente não Existe"));
        Company companyClient = client.getCompanyUser();

        float balanceClient;

        if (type == TypeTransition.DEPOSITO) {
            balanceClient = client.getAccountValue() +(transactionDto.getValue() - companyClient.getDepositFee());
            companyClient.setBalance(companyClient.getBalance() + transactionDto.getValue());
        } else if (type == TypeTransition.SAQUE) {
            balanceClient = client.getAccountValue() - transactionDto.getValue() - companyClient.getWithdrawalFee();
            companyClient.setBalance( companyClient.getBalance() + transactionDto.getValue());
        } else {
            throw new IllegalArgumentException("Tipo de transação inválido");
        }

        client.setAccountValue(balanceClient);

        companyRepository.save(companyClient);
        clientRepository.save(client);

        Transition transitionClient = new Transition(
                type,
                transactionDto.getValue(),
                LocalTime.now(),
                companyClient,
                client
        );

        return transitionRepository.save(transitionClient);
    }

    public Transition clientDeposit(TransitionDto deposit, long id) throws Exception {
        return performTransaction(TypeTransition.DEPOSITO, deposit, id);
    }

    public Transition clientWithdraw(TransitionDto withdraw, long id) throws Exception {
        return performTransaction(TypeTransition.SAQUE, withdraw, id);
    }
}
