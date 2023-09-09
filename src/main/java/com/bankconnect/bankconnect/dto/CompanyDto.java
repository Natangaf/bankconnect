package com.bankconnect.bankconnect.dto;

public class CompanyDto {

    private String cnpj;

    private String name;

    private String address;

    private String telephone;

    private float depositFee;

    private float withdrawalFee;

    private float balance;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public float getDepositFee() {
        return depositFee;
    }

    public void setDepositFee(float depositFee) {
        this.depositFee = depositFee;
    }

    public float getWithdrawalFee() {
        return withdrawalFee;
    }

    public void setWithdrawalFee(float withdrawalFee) {
        this.withdrawalFee = withdrawalFee;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
