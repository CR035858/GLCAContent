package com.gl.studentapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.studentapi.model.Student;
import com.gl.studentapi.service.StudentService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping(value="/allStudents")
	public List <Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping(value="/allStudents/{studId}")
	public Student getStudentById(@PathVariable int studId)
	{
		return studentService.getStudentById(studId);
	}
	
	@PostMapping(value="/allStudents")
	public String addStudentDetails(@RequestBody Student student)
	{
		studentService.saveStudent(student);
		return "Student Details Added Successfully...";
	}
	
	@PutMapping(value="/allStudents")
	public String updateStudentDetails(@RequestBody Student student,@RequestParam int id)
	{
		studentService.updateStudent(student, id);
		return "Student Details Updated Successfully...";
	}
	
	@DeleteMapping(value="/allStudents/{studId}")
	public String deleteStudentById(@PathVariable int studId)
	{
		studentService.deleteStudentById(studId);
		return "Student Details Deleted Successfully";
	}
}
