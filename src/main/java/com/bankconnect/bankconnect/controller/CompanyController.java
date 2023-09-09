package com.bankconnect.bankconnect.controller;

import com.bankconnect.bankconnect.dto.CompanyDto;
import com.bankconnect.bankconnect.model.Company;
import com.bankconnect.bankconnect.service.CompanyServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyServices companyService;

    public CompanyController(CompanyServices companyServices) {
        this.companyService = companyServices;
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody final CompanyDto companyData) {
        Company companyRes = companyService.createCompany(companyData);

        return new ResponseEntity<Company>(companyRes, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Company>> listCompany() {
        List<Company> companyList = companyService.readCompany();

        return new ResponseEntity<List<Company>>(companyList, HttpStatus.OK);
    }
}
