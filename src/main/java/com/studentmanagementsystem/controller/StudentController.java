package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.repository.StudentRepository;
import com.studentmanagementsystem.service.StudentService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String getAllStudent(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/student/new")
    public String createStudentForm(Model model, Student student) {
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/student")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/student";
    }


    @GetMapping("/students/edit/{id}")
    public String updateStudentForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }


    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        //get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());


        //save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/student";


    }
}
