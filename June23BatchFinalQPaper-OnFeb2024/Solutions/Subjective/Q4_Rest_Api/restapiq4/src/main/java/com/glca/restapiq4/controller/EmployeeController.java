package com.glca.restapiq4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glca.restapiq4.model.Employee;
import com.glca.restapiq4.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@PostMapping("/save")
	public ResponseEntity <Employee> saveEmployee(@RequestBody Employee employee)
	{
		if(empService.saveEmployee(employee))
		{
			return new ResponseEntity<>(employee,HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<>(employee,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity <Employee> updateEmployee(@PathVariable("empId") int empId,@RequestBody Employee employee)
	{
		if(empService.updateEmployee(employee,empId))
		{
			return new ResponseEntity<>(employee,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(employee,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity <Employee> deleteEmployee(@PathVariable("empId") int empId)
	{
		Employee employee = empService.getEmployeeById(empId);
		if(empService.deleteEmployeeById(empId))
		{
			return new ResponseEntity<>(employee,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(employee,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity <Employee> getEmployeeById(@PathVariable("empId") int empId)
	{
		if (empService.getEmployeeById(empId) != null)
		{
			Employee employee = empService.getEmployeeById(empId);
			return new ResponseEntity<>(employee,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/")
	public ResponseEntity <List <Employee>> getAllEmployees()
	{
		List <Employee> employees = empService.getAllEmployees();
		return new ResponseEntity <>(employees,HttpStatus.OK);
	}

}
