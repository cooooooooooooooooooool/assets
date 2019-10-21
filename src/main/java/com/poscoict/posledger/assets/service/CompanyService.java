package com.poscoict.posledger.assets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.posledger.assets.model.Company;
import com.poscoict.posledger.assets.repository.CompanyRepository;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    public void addCompany(Company company) {
    	companyRepository.save(company);
    }
}