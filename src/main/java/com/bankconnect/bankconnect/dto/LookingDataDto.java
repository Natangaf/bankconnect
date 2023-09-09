package com.bankconnect.bankconnect.dto;

import com.bankconnect.bankconnect.model.Client;
import com.bankconnect.bankconnect.model.Company;

public class LookingDataDto {

    private Client client;
    private Company companyClient;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Company getCompanyClient() {
        return companyClient;
    }

    public void setCompanyClient(Company companyClient) {
        this.companyClient = companyClient;
    }
}
