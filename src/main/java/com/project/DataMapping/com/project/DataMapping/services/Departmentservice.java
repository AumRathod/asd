package com.project.DataMapping.com.project.DataMapping.services;


import com.project.DataMapping.com.project.DataMapping.entities.DepartmentEntity;
import com.project.DataMapping.com.project.DataMapping.entities.EmployeeEntity;
import com.project.DataMapping.com.project.DataMapping.repositories.DepartmentRepository;
import com.project.DataMapping.com.project.DataMapping.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Departmentservice {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public Departmentservice(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }



    public DepartmentEntity createDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id ){
        return departmentRepository.findById(id).orElse(null);
    }


    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return departmentEntity
                .flatMap(department -> {
                            return employeeEntity.map(employee -> {
                                department.setManager(employee);
                                return departmentRepository.save(department);
                            });
                        }
                ).orElse(null);

    }

    public DepartmentEntity assignedDepartmentOfManager(Long employeeId) {
        //Option : 1
        //Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
//        return employeeEntity.map( employee ->employee.getManagedDepartment()
//        ).orElse(null);

        EmployeeEntity employeeEntity = EmployeeEntity.builder().id(employeeId).build();

        return departmentRepository.findByManager(employeeEntity);



    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId, Long employeeId) {

            System.out.println("Put Service Worker");
            Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
            Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

            System.out.println("Put Service Worker 2 ");

            return departmentEntity
                    .flatMap(department ->
                                 employeeEntity.map(employee -> {
                                    System.out.println("Put Service Worker 4 ");

                                    employee.setWorkerDepartment(department);
                                    employeeRepository.save(employee);
                                    System.out.println("Put Service Worker 5 ");
                                    department.getWorkers().add(employee);

                                    return department;
                                })).orElse(null);


        }

    public DepartmentEntity assignFreelancerToDepartment(Long departmentId, Long employeeId) {

        System.out.println("Put Service Freelancers");
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);


        return departmentEntity
                .flatMap(department ->
                        employeeEntity.map(employee -> {

                            employee.getFreelanceDepartments().add(department);
                            employeeRepository.save(employee);

                            department.getFreelancers().add(employee);
                            //We can save department as well but we have done Join Table in employee it's better we save employee with dept
                            //then we return the fresh department it'll now allow ManyToMany
                            //departmentRepository.save(department);
                           return department;
                        })).orElse(null);


    }
}
