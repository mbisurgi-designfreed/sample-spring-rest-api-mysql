package com.designfreed.sampleapp.rest;

import com.designfreed.sampleapp.domain.Employee;
import com.designfreed.sampleapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public List<Employee> listAll() {
        return employeeService.findAll();
    }

    @GetMapping("/find/{id}")
    public Employee findById(@PathVariable(name = "id") String id) {
        return employeeService.findById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<Employee> add(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.saveOrUpdate(employee);

        ResponseEntity<Employee> response;

        if (newEmployee != null) {
            response = ResponseEntity.ok(newEmployee);
        } else {
            response = ResponseEntity.noContent().build();
        }

        return response;
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Employee> edit(@PathVariable(name = "id") String id, @RequestBody Employee employee) {
        employee.setId(id);
        Employee updateEmployee = employeeService.saveOrUpdate(employee);

        ResponseEntity<Employee> response;

        if (updateEmployee != null) {
            response = ResponseEntity.ok(updateEmployee);
        } else {
            response = ResponseEntity.noContent().build();
        }

        return response;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        employeeService.deleteById(id);
    }
}
