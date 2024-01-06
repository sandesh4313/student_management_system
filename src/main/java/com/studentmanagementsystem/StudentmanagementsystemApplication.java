package com.studentmanagementsystem;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentmanagementsystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementsystemApplication.class, args);
	}
@Autowired
	 private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {


	}
}
