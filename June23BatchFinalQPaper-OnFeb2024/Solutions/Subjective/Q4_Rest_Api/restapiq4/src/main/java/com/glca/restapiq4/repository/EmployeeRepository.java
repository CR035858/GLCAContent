package com.glca.restapiq4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glca.restapiq4.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Integer>{

}
