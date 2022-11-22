package com.javatutorial.studentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatutorial.studentmanagementsystem.entity.Student;
import com.javatutorial.studentmanagementsystem.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService service;
	
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	@GetMapping(path = "students")
	public String getAllStudents(Model model) {
		model.addAttribute("students",service.getAllStudents());
		return "students";
	}
	
	@GetMapping(path = "students/new")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	@PostMapping("students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping(path = "students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student",service.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping(path = "students/{id}")
	public String updateStudent(
			@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model
			) {
	/*	
		Student existingStudent = service.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		*/
		service.updateStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
		return "redirect:/students";
	}

}
