package glcamavenjsphiber1.gl.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="employeeName")
	String employeeName;
	
	@Column(name="employeeAddress")
	String employeeAddress;
	
	@Column(name="employeePhone")
	String employeePhone;
	
	@Column(name="employeeSalary")
	int employeeSalary;

	
	public Employee() {
		super();
	}


	public Employee(int id, String employeeName, String employeeAddress, String employeePhone, int employeeSalary) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeePhone = employeePhone;
		this.employeeSalary = employeeSalary;
	}
	public Employee(String employeeName, String employeeAddress, String employeePhone, int employeeSalary) {
		super();
		
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeePhone = employeePhone;
		this.employeeSalary = employeeSalary;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmployeeAddress() {
		return employeeAddress;
	}


	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}


	public String getEmployeePhone() {
		return employeePhone;
	}


	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}


	public int getEmployeeSalary() {
		return employeeSalary;
	}


	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", employeeAddress=" + employeeAddress
				+ ", employeePhone=" + employeePhone + ", employeeSalary=" + employeeSalary + "]";
	}
	
	
	

}
