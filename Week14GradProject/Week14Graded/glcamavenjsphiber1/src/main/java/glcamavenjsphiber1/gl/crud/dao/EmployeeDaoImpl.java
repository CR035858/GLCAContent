package glcamavenjsphiber1.gl.crud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import glcamavenjsphiber1.gl.crud.entity.Employee;

@Repository
@EnableTransactionManagement
public class EmployeeDaoImpl implements EmployeeDao{
	
	SessionFactory sessionFactory;
	Session session;
	
	public EmployeeDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
		this.session = sessionFactory.openSession();
	}

	@Override
	@Transactional
	public Employee getEmployeeByIdDao(int id) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		Transaction tx = session.beginTransaction();
			employee = session.get(Employee.class, id);
		tx.commit();
		return employee;
	}

	@Override
	public List<Employee> getAllEmployeesDao() {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
			List <Employee> employees  = session.createQuery("from Employee").list();
		tx.commit();
		return employees;
	}

	@Override
	public void saveEmployeeDao(Employee employee) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
			session.save(employee);
		tx.commit();
	}

	@Override
	public void deleteEmployeeDao(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		Employee employee = session.get(Employee.class, id);
		session.delete(employee);
		tx.commit();
		
		
	}

	

}
