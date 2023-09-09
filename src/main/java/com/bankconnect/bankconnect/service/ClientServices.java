package com.bankconnect.bankconnect.service;

import com.bankconnect.bankconnect.model.Client;
import com.bankconnect.bankconnect.model.Company;
import com.bankconnect.bankconnect.repository.ClientRepository;
import com.bankconnect.bankconnect.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {

    private final ClientRepository clientRepository;
    private final CompanyRepository companyRepository;

    public ClientServices(ClientRepository clientRepository, CompanyRepository companyRepository) {
        this.clientRepository = clientRepository;
        this.companyRepository = companyRepository;
    }

    public Client createClient(final Client clientData) {
        String companyName = clientData.getCompanyUser().getName();
        Company companyUser = companyRepository.findByName(companyName);

        final Client client = new Client(
                clientData.getCpf(),
                clientData.getAddress(),
                clientData.getName(),
                clientData.getTelephone(),
                clientData.getAccountValue(),
                companyUser);

        return clientRepository.save(client);
    }

    public List<Client> readClient() {
        return clientRepository.findAll();
    }

    public Client retriverClient(final long id) throws Exception {
        return clientRepository.findById(id).orElseThrow(()->new Exception(" Cliente não Existe"));
    }

    public Client updateClient (final Client client,final long id) throws Exception{

        final Client oldClient = clientRepository.findById(id).orElseThrow(()->new Exception(" Cliente não Existe"));
        oldClient.setName(client.getName());
        oldClient.setAddress(client.getAddress());
        oldClient.setTelephone(client.getTelephone());

        return  clientRepository.save(oldClient);
    }

    public void deleteClient (final long id) throws Exception{

        final Client client = clientRepository.findById(id).orElseThrow(()->new Exception(" Cliente não Existe"));

         clientRepository.delete(client);
    }


}