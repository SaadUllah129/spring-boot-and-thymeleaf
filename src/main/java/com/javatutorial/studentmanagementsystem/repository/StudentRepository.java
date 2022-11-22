package com.javatutorial.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatutorial.studentmanagementsystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	

}
