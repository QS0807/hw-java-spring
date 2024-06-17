package com.example.hw_java_spring.service;

import com.example.hw_java_spring.dto.StudentDto;
import com.example.hw_java_spring.entity.Student;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long studentId);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Long studentId, StudentDto updateStudent);

    void deleteStudent(Long studentId);
}

