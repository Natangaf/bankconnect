package com.bankconnect.bankconnect.model;

import jakarta.persistence.*;


@Entity
@Table(name = "company")
public class Company {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private long id;

      @Column(unique = true, length = 14)
      private String cnpj;

      @Column()
      private String name;

      @Column()
      private String address;

      @Column(unique = true, length = 11)
      private String telephone;

      @Column(unique = true)
      private float depositFee;

      @Column(unique = true)
      private float withdrawalFee;
      @Column()
      private float balance;

      public Company() {

      }
      public Company(String cnpj, String name, String address, String telephone, float depositFee, float withdrawalFee, float balance) {
            this.cnpj = cnpj;
            this.name = name;
            this.address = address;
            this.telephone = telephone;
            this.depositFee = depositFee;
            this.withdrawalFee = withdrawalFee;
            this.balance = balance;
      }

      public long getId() {
            return id;
      }

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
