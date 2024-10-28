package com.gl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name="Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="first_Name")
	String first_Name;	
	
	@Column(name="last_Name")
	String last_Name;
	
	@Column(name="eMail")
	String eMail;

	
	public Student() {
		super();
	}

	public Student(int id, String first_Name, String last_Name, String eMail) {
		super();
		this.id = id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.eMail = eMail;
	}

	public Student(String first_Name, String last_Name, String eMail) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.eMail = eMail;
	}

	@ManyToMany(fetch=FetchType.LAZY,
		    cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                      CascadeType.DETACH, CascadeType.REFRESH})
     @JoinTable(
		name="course_student",
		joinColumns=@JoinColumn(name="student_id"),
		inverseJoinColumns=@JoinColumn(name="course_id")
		)
	private List <Course> courses;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", eMail=" + eMail
				+ "]";
	}	

	
	public void addCourse(Course course) {
		if(courses == null) {
			courses = new ArrayList<>();
		}
		courses.add(course);
	}
	
}
