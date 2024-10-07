package glcamavenjsphiber1.gl.crud.service;

import java.util.List;

import glcamavenjsphiber1.gl.crud.entity.Employee;



public interface EmployeeService {
	
	public Employee getEmployeeByIdSvc(int id);
	public List <Employee> getAllEmployeesSvc();
	public void saveEmployeeSvc(Employee employee);
	public void deleteEmployeeSvc(int id);

}
