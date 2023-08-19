package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;

@Controller
public class StudentController {

	private StudentService studentservice;

	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}
	//handler method to handle list student  and return model and view
	@GetMapping("/students")
	public String listStudent(Model model) {
		model.addAttribute("students", studentservice.getAllStudents());
		return "students";	
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student" , student);
		return "create_student";	
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentservice.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id , Model model) {
		model.addAttribute("student" , studentservice.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student, Model model) {
		
		//get student from db by id 
		Student existingStudent = studentservice.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setEmail(student.getEmail());
		
		//save updated student obj
		
		studentservice.updateStudent(existingStudent);
		return "redirect:/students";
		
	}
	
	//handler methd to delete student request
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentservice.deleteStudentById(id);
		return "redirect:/students";
		
	}
	
	
	
	
	
	
	
}
