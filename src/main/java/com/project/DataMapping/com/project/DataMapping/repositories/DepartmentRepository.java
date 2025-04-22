package com.project.DataMapping.com.project.DataMapping.repositories;

import com.project.DataMapping.com.project.DataMapping.entities.DepartmentEntity;
import com.project.DataMapping.com.project.DataMapping.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity , Long> {

    DepartmentEntity findByManager(EmployeeEntity employeeEntity);
}
