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
@RequestMapping("/employees")
public class EmployeesResource {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    private EmployeeService employeeService;

    @Autowired
    public EmployeesResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Employee>> getAll() {

        List<Employee> employees = employeeService.getAll();

        return ResponseEntity.ok(employees);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployeesByQuery(@RequestParam(value = "page",defaultValue ="0",required = false) int page,
                                      @RequestParam(value="pageSize",defaultValue = "5" ,required = false) int pageSize,
                                      @RequestParam(value="gender",defaultValue = "Male",required = false) String gender) {



        List<Employee> employees = employeeService.getEmployeesByQuery( page, pageSize, gender);

        return ResponseEntity.ok(employees);

    }

    @PostMapping(produces = {"application/json"})
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }


    @DeleteMapping(value = "/{id}",produces = {"application/json"})
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }
    @PutMapping(value = "/{id}",produces = {"application/json"})
    public void EditEmployee(@RequestBody Employee employee,@PathVariable Long id) {
        employeeService.EditEmployeeById(employee,id);
    }

}
