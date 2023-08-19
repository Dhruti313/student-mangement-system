package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class SpringbootExmapleStudentMangSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExmapleStudentMangSystemApplication.class, args);
		
	}
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
	Student student1 = new Student( "ram" , "patel" , "ramgmail.com");
	//studentRepository.save(student1);
	
	Student student2 = new Student( "dhruti" , "vachhani" , "dhrutigmail.com");
	//studentRepository.save(student2);

	Student student3 = new Student( "chirag" , "makadiya" , "chiraggmail.com");
	//studentRepository.save(student3);


}
}