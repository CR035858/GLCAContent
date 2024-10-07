package com.glca.restapiq4.service;

import java.util.List;

import com.glca.restapiq4.model.Employee;

public interface EmployeeService {
	
	public List <Employee> getAllEmployees();
	public Employee getEmployeeById(int empId);
	public boolean deleteEmployeeById(int empId);
	public boolean updateEmployee(Employee employee,int empId);
	public boolean saveEmployee(Employee employee);

}
