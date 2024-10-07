package com.glca.restapiq4.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.glca.restapiq4.model.Employee;
import com.glca.restapiq4.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		Employee employeeFound;
		 try
    	 {
			 employeeFound = empRepo.findById(empId).get();
    		 return employeeFound;
       	 }	
    	 catch(NoSuchElementException nse)
      	{
      		
             System.out.println("Employee Not Found.");
             return null;
      	}
	}

	@Override
	public boolean deleteEmployeeById(int empId) {
		// TODO Auto-generated method stub
		
		 Employee employeeFound ;
	    	try
	    	{
	    		employeeFound = getEmployeeById(empId);
	    		if(employeeFound != null)
	    		{
	    			empRepo.deleteById(empId);
	    			return true;
	    		}
	  
	    	}
	    	catch(NoSuchElementException nse)
	    	{
	    		
	             System.out.println("Employee Not Found... ");
	             return false;
	    	}
	    	 return false;
	}

	@Override
	public boolean updateEmployee(Employee employee,int empId) {
		// TODO Auto-generated method stub
		Employee employeeU ;
    	try
    	{
    		employeeU  = empRepo.findById(empId).get();
	        employeeU.setFirstName(employee.getFirstName());
	        employeeU.setLastName(employee.getLastName());
	        employeeU.setSalary(employee.getSalary());
	        empRepo.save(employeeU);
	        return true;
  
    	}
    	catch(NoSuchElementException nse)
    	{
    		 
             System.out.println(" Employee Not found..");
             return false;
    	}
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee employeeS ;
    	try
    	{
    		employeeS = getEmployeeById(employee.getEmpId());
    		if(employeeS == null)
    		{
    			empRepo.save(employee);
                 System.out.println("Saved Employee..."+employee);
                 return true;
    		}
  
    	}
    	catch(NoSuchElementException nse)
    	{
    		return false;
    	}
    	return false;
		
	}

}
