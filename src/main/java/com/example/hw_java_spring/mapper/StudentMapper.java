package com.example.hw_java_spring.mapper;

import com.example.hw_java_spring.dto.StudentDto;
import com.example.hw_java_spring.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getGender()
        );
    }
    public static Student mapToStudent(StudentDto studentDto){
        return new Student(
                studentDto.getId(),
                studentDto.getFirst_name(),
                studentDto.getLast_name(),
                studentDto.getEmail(),
                studentDto.getGender()
        );
    }
}
