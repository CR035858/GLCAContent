package com.gl.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.studentapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
