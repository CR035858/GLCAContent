package com.gl.store.hrinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.store.hrinventory.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
