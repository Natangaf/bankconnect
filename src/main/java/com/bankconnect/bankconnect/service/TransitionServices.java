package com.bankconnect.bankconnect.service;

import com.bankconnect.bankconnect.dto.CreateDepositDto;
import com.bankconnect.bankconnect.model.Client;
import com.bankconnect.bankconnect.model.Company;
import com.bankconnect.bankconnect.model.Transition;
import com.bankconnect.bankconnect.model.TypeTransition;
import com.bankconnect.bankconnect.repository.ClientRepository;
import com.bankconnect.bankconnect.repository.CompanyRepository;
import com.bankconnect.bankconnect.repository.TransitionRepository;

import java.time.LocalTime;

public class TransitionServices {
    private final TransitionRepository transitionRepository;
    private final ClientRepository clientRepository;
    private final CompanyRepository companyRepository;

    public TransitionServices(TransitionRepository transitionRepository, ClientRepository clientRepository, CompanyRepository companyRepository) {
        this.transitionRepository = transitionRepository;
        this.clientRepository = clientRepository;
        this.companyRepository = companyRepository;
    }

    public Transition clientDeposit(final CreateDepositDto deposit , final long id) throws Exception{

        final Client client = clientRepository.findById(id).orElseThrow(()->new Exception(" Cliente não Existe"));

        final long companyIdClient = client.getCompanyUser().getId();

        final Company companyClient = companyRepository.findById(companyIdClient).orElseThrow(() -> new Exception(" Cliente não Existe"));

        final float rate = deposit.getValue() - companyClient.getDepositFee();

        final float balance = (client.getAccountValue() + rate);

        companyClient.setBalance(companyClient.getBalance() + rate );

        client.setAccountValue(balance);

        companyRepository.save(companyClient);

        clientRepository.save(client);

        final Transition transitionClient = new Transition(
                TypeTransition.DEPOSITO,
                deposit.getValue(),
                LocalTime.now(),
                companyClient,
                client
        );

        return  transitionRepository.save(transitionClient);
    }

}
