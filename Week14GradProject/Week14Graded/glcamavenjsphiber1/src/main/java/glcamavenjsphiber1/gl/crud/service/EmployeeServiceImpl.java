package glcamavenjsphiber1.gl.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import glcamavenjsphiber1.gl.crud.dao.EmployeeDao;
import glcamavenjsphiber1.gl.crud.entity.Employee;

@Service
@EnableTransactionManagement
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Employee getEmployeeByIdSvc(int id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeByIdDao(id);
	}

	@Override
	public List<Employee> getAllEmployeesSvc() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployeesDao();
	}

	@Override
	public void saveEmployeeSvc(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.saveEmployeeDao(employee);
		
	}

	@Override
	public void deleteEmployeeSvc(int id) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployeeDao(id);
		
	}

}
