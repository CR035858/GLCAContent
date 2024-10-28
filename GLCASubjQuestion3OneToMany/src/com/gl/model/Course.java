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
@Table(name="Course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int	id;	
	
	@Column(name="title")
	String title;	
	
	@Column(name="instructor_Id")
	int instructorId;
	
	
	
	public Course() {
		super();
	}


	public Course(int id, String title, int instructorId) {
		super();
		this.id = id;
		this.title = title;
		this.instructorId = instructorId;
	}
	
	
	
	public Course(String title, int instructorId, List<Student> students) {
		super();
		this.title = title;
		this.instructorId = instructorId;
		this.students = students;
	}



	@ManyToMany(fetch=FetchType.LAZY,
		    cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                      CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
		name="course_student",
		joinColumns=@JoinColumn(name="course_id"),
		inverseJoinColumns=@JoinColumn(name="student_id")
		)
	private List <Student> students;



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getInstructorId() {
		return instructorId;
	}


	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructorId=" + instructorId + "]";
	}

	public void addStudent(Student student) {
		if(students == null) {
			students = new ArrayList<>();
		}
		students.add(student);
	}
	
	

}
