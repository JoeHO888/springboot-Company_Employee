package com.tw.apistackbase.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CompanyService {

    private List<Company> companies= new ArrayList();
    private int id = 0;

    public CompanyService (){
        Company companyA = new Company("Xiaoming","Male");
        companyA.setId(id);
        companies.add(companyA);
        id++;

        Company companyB = new Company("Xiaoming","Male");
        companyB.setId(id);
        companies.add(companyB);
        id++;

        Company companyC = new Company("Xiaoming","Male");
        companyC.setId(id);
        companies.add(companyC);
        id++;

        Company companyD = new Company("Xiaoming","Male");
        companyD.setId(id);
        companies.add(companyD);
        id++;

        Company companyE = new Company("Xiaoming","Male");
        companyE.setId(id);
        companies.add(companyE);
        id++;

    }

    public List<Company> getAll(){
        return this.companies;
    }

    public void addEmployee(Company company){
        company.setId(this.id);
        this.id++;
        companies.add(company);
    }

    public void deleteEmployeeById(Long id){
        companies.removeIf(s -> s.getId() == id);
    }

    public void EditEmployeeById(Company newCompany,Long id){
        Optional<Company> existingCompany = companies.stream().filter(e -> e.getId() == id).findFirst();
        if (existingCompany.isPresent()){
            Company existingEmployeeWithExistence = companies.stream().filter(e -> e.getId() == id).findFirst().get();
            existingEmployeeWithExistence.setBrand(newCompany.getBrand());
        }else {
            addEmployee(newCompany);
        }


    }


}
