package com.studentmanagementsystem.service;

import com.studentmanagementsystem.dto.StudentDto;
import com.studentmanagementsystem.entity.Student;

import java.util.List;

public interface StudentService {


    public List<Student> getAllStudent();

    public Student saveStudent(StudentDto student);

    public Student getStudentById(Long id);

    public Student updateStudent(Student student);
}
