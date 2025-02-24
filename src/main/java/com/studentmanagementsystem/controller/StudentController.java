package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.dto.StudentDto;
import com.studentmanagementsystem.service.StudentService;
import com.studentmanagementsystem.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.studentmanagementsystem.entity.Student;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        try {
            Student student = studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        } catch (StudentNotFoundException ex) {
            // If the student is not found, return a 404 NOT FOUND response
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Save a new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentDto student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    // Update an existing student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id); // Ensure we are updating the right student with the correct ID
        try {
            Student updatedStudent = studentService.updateStudent(student);
            return ResponseEntity.ok(updatedStudent);
        } catch (StudentNotFoundException ex) {
            // If the student is not found, return a 404 NOT FOUND response
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    }


