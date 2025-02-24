package com.studentmanagementsystem.service.serviceimpl;

import com.studentmanagementsystem.dto.StudentDto;
import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.repository.StudentRepository;
import com.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }



    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student saveStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(null);
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());



        return studentRepository.save(student);
    }
}
