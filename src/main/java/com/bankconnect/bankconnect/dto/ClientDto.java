package com.bankconnect.bankconnect.dto;

import com.bankconnect.bankconnect.model.Company;

public class ClientDto {
    private long cpf;

    private String name;

    private String address;

    private long telephone;

    private String companyUser;

    private float accountValue;

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
    }

    public float getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(float accountValue) {
        this.accountValue = accountValue;
    }
}
