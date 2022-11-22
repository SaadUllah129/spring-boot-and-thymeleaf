package com.javatutorial.studentmanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javatutorial.studentmanagementsystem.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudent(Long id);
}
