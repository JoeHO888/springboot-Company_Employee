package com.tw.apistackbase.controller;

import com.tw.apistackbase.controller.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/companies")
public class CompaniesResource {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    private CompanyService companyService;

    @Autowired
    public CompaniesResource(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Company>> getAll() {

        List<Company> companies = companyService.getAll();

        return ResponseEntity.ok(companies);
    }

    @PostMapping(produces = {"application/json"})
    public void addEmployee(@RequestBody Company company) {
        companyService.addEmployee(company);
    }
    @DeleteMapping(value = "/{id}",produces = {"application/json"})
    public void deleteEmployee(@PathVariable Long id) {
        companyService.deleteEmployeeById(id);
    }
    @PutMapping(value = "/{id}",produces = {"application/json"})
    public void EditEmployee(@RequestBody Company company,@PathVariable Long id) {
        companyService.EditEmployeeById(company,id);
    }

}
