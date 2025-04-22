package com.project.DataMapping.com.project.DataMapping.services;


import com.project.DataMapping.com.project.DataMapping.entities.EmployeeEntity;
import com.project.DataMapping.com.project.DataMapping.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity)
    {
        System.out.println("Employee Service : ");
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

}
