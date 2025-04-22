package com.project.DataMapping.com.project.DataMapping.repositories;

import com.project.DataMapping.com.project.DataMapping.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity ,Long> {
}
