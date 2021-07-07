package com.company.abc.controller;

import com.company.abc.domain.Company;
import com.company.abc.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Company> getCompanyList(){
        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable Long id){
        return companyService.getCompany(id);
    }

    @PostMapping
    public Company insertCompany(@RequestBody Company company){
        return companyService.save(company);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company req){
        Company company = companyService.getCompany(id);
        company.setName(req.getName());
        company.setAddress(req.getAddress());

        return companyService.save(company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
    }



}
