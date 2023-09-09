package com.bankconnect.bankconnect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, length = 11)
    private long cpf;

    @Column()
    private String name;

    @Column()
    private String address;

    @Column(length = 11, unique = true)
    private long telephone;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Company companyUser;

    @Column(columnDefinition  = "DECIMAL DEFAULT 0.0")
    private float accountValue;


    public Client() {
    }

    public Client(long cpf, String name, String address, long telephone,float accountValue, Company companyUser) {
        this.cpf = cpf;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.accountValue =  accountValue;
        this.companyUser = companyUser;
    }

    public long getId() {
        return id;
    }

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

    public float getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(float accountValue) {
        this.accountValue = accountValue;
    }

    public Company getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(Company companyUser) {
        this.companyUser = companyUser;
    }


}
