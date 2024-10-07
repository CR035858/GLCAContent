package glcamavenjsphiber1.gl.crud.dao;

import java.util.List;

import glcamavenjsphiber1.gl.crud.entity.Employee;

public interface EmployeeDao {
	
	public Employee getEmployeeByIdDao(int id);
	public List <Employee> getAllEmployeesDao();
	public void saveEmployeeDao(Employee employee);
	public void deleteEmployeeDao(int id);

}
