package com.bankconnect.bankconnect.service;

import com.bankconnect.bankconnect.model.Company;
import com.bankconnect.bankconnect.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServices {
    private final CompanyRepository companyRepository;

    public CompanyServices(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company createCompany(final Company companyData){

        final Company company = new Company(
                companyData.getCnpj(),
                companyData.getName(),
                companyData.getAddress(),
                companyData.getTelephone(),
                companyData.getDepositFee(),
                companyData.getWithdrawalFee(),
                companyData.getBalance()
        );

        return companyRepository.save(company);

    }

    public List<Company> readCompany(){
        return companyRepository.findAll();
    }
}
