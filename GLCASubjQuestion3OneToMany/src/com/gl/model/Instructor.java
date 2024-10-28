package com.gl.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name="Instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="instructorId")
	int instructorId;
	
	@Column(name="first_Name")
	String first_Name;	
	
	@Column(name="last_Name")
	String last_Name;
	
	
	public Instructor() {
		super();
	}
		
	
	public Instructor(int instructorId, String first_Name, String last_Name) {
		super();
		this.instructorId = instructorId;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
	}
	

	public Instructor(String first_Name, String last_Name) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;

	}


	//Set up mapping between Instructor and Instructor_Detail entities - ONE TO ONE UNI
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private Instructor_Detail instructorDetail;

	//Set up mapping between Instructor and Course entities - ONE TO MANY UNI
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_id")
	private List <Course> courses;
	

	public int getInstructorId() {
		return instructorId;
	}


	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
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


	public Instructor_Detail getInstructorDetail() {
		return instructorDetail;
	}


	public void setInstructorDetail(Instructor_Detail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	

	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", first_Name=" + first_Name + ", last_Name=" + last_Name
				+ "]";
	}
	
	
	
	
	
}
