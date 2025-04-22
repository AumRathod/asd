package com.project.DataMapping.com.project.DataMapping.controllers;

import com.project.DataMapping.com.project.DataMapping.entities.DepartmentEntity;
import com.project.DataMapping.com.project.DataMapping.services.Departmentservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {


    private final Departmentservice departmentservice;

    public DepartmentController(Departmentservice departmentservice) {
        this.departmentservice = departmentservice;
    }

    @GetMapping("/{departmentId}")
    public DepartmentEntity getdepartmentById(@PathVariable Long departmentId ){
        return departmentservice.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createDepartment(@RequestBody DepartmentEntity departmentEntity){
        return departmentservice.createDepartment(departmentEntity);
    }

    @PutMapping(path = "/{departmentId}/manager/{employeeId}")
    public DepartmentEntity assignManagerToDepartment(
            @PathVariable Long departmentId ,
            @PathVariable Long employeeId)
    {
        return departmentservice.assignManagerToDepartment(departmentId, employeeId);
    }

    @GetMapping(path = "/assignedDepartmentOfManager/{employeeId}")
    public DepartmentEntity assignedDepartmentOfManager( @PathVariable Long employeeId){
        return departmentservice.assignedDepartmentOfManager(employeeId);
    }

    @PutMapping(path = "/{departmentId}/worker/{employeeId}")
    public DepartmentEntity assignWorkerToDepartment(
            @PathVariable Long departmentId ,
            @PathVariable Long employeeId)
    {
        System.out.println("Put Mapping for Worker");
        return departmentservice.assignWorkerToDepartment(departmentId, employeeId);
    }

    @PutMapping(path = "/{departmentId}/freelancer/{employeeId}")
    public DepartmentEntity assignFreelancerToDepartment(
            @PathVariable Long departmentId ,
            @PathVariable Long employeeId)
    {
        System.out.println("Put Mapping for Worker");
        return departmentservice.assignFreelancerToDepartment(departmentId, employeeId);
    }


}
