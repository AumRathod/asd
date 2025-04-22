package com.project.DataMapping.com.project.DataMapping.controllers;


import com.project.DataMapping.com.project.DataMapping.entities.EmployeeEntity;
import com.project.DataMapping.com.project.DataMapping.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId )
    {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity)
    {
        System.out.println("Employee Creation : ");
        return employeeService.createEmployee(employeeEntity);

    }


}
