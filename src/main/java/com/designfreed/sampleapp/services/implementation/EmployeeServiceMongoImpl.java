package com.designfreed.sampleapp.services.implementation;

import com.designfreed.sampleapp.domain.Employee;
import com.designfreed.sampleapp.repositories.EmployeeRepository;
import com.designfreed.sampleapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceMongoImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee saveOrUpdate(Employee domainObject) {
        return employeeRepository.save(domainObject);
    }

    @Override
    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }
}
