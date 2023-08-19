package com.example.demo.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.services.StudentService;

@Service
public class StudentServiceImpl  implements StudentService{

	//dependency
	private StudentRepository studentrepository;
	//constructor based dependency
	public StudentServiceImpl(StudentRepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	}
	
	@Override
	public List<Student> getAllStudents() {
		
		return studentrepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentrepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
	
		return studentrepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentrepository.save(student);
	}

	@Override
	public void deleteStudentById(long id) {
		studentrepository.deleteById(id);
		
	}
	

}
