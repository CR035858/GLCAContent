package com.gl.store.hrinventory.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.store.hrinventory.model.Student;
import com.gl.store.hrinventory.model.Teacher;
import com.gl.store.hrinventory.repository.StudentRepository;
import com.gl.store.hrinventory.repository.TeacherRepository;

@RestController
@RequestMapping("/school")
public class SchoolController {

	private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public SchoolController(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        
    }

    @GetMapping("/greet")
    public String sayHello()
    {
        return "Welcome to Hacker Rank";
    }
    //create teacher
    @PostMapping("/teacher")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher _teacher = teacherRepository.save(teacher);
        
        return new ResponseEntity<>(_teacher, HttpStatus.CREATED);
    }

    //create student
    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student _student = studentRepository.save(student);
        return new ResponseEntity<>(_student, HttpStatus.CREATED);
    }

    //add student to a teacher // NOTE ADDING A STUDENT TO EXISTING TEACHER AND THEN SAVING THAT TEACHER UPDATES 
    						// TEACHER WITH STUDENT IN JOIN TABLE TOO
    @PostMapping("/teacher/{teacherId}/addStudent")
    public ResponseEntity<Teacher> addStudent(@PathVariable(value = "teacherId") Long teacherId, @RequestBody Student addStudent) {
        //TODO
        Teacher _teacher = teacherRepository.findById(teacherId).get();
        /* Set <Student> students = new HashSet<>();
         students.add(addStudent);
         _teacher.setStudents(students);*/
        _teacher.addStudent(addStudent);
      //  studentRepository.save(addStudent);
        teacherRepository.save(_teacher);
        return new ResponseEntity <> (_teacher,HttpStatus.CREATED);
    }
    
  //add teacher to a student - THIS WAS ADDITIONALLY ADDED - NOT IN REQUIREMENT ACTUALLY NOT NECESSARY JUST CHECKED
    @PostMapping("/student/{studentId}/addTeacher")
    public ResponseEntity<Student> addTeacher(@PathVariable(value = "studentId") Long studentId, @RequestBody Teacher addTeacher) {
        //TODO
        Student _student = studentRepository.findById(studentId).get();
        /* Set <Student> students = new HashSet<>();
         students.add(addStudent);
         _teacher.setStudents(students);*/
        _student.addTeacher(addTeacher);
      //  studentRepository.save(addStudent);
        studentRepository.save(_student);
        return new ResponseEntity <> (_student,HttpStatus.CREATED);
    }
    

    //get students of a teacher
    @GetMapping("/teacher/{teacherId}/students")
    public ResponseEntity<Set<Student>> getStudentsOfATeacher(@PathVariable(value = "teacherId") Long teacherId) {
        //TODO
       Teacher _teacher = teacherRepository.findById(teacherId).get();
       Set <Student> students = _teacher.getStudents();
        return new ResponseEntity <> (students,HttpStatus.OK);
        
    }

    // get teachers of a student
    @GetMapping("/student/{studentId}/teachers")
    public ResponseEntity<Set<Teacher>> getTeachersOfAStudent(@PathVariable(value = "studentId") Long studentId) {
        //TODO
        Student _student = studentRepository.findById(studentId).get();
        Set <Teacher> teachers = _student.getTeachers();
        return new ResponseEntity <> (teachers, HttpStatus.OK);
       
    }
}
