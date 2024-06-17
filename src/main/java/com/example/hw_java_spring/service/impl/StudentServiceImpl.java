package com.example.hw_java_spring.service.impl;

import com.example.hw_java_spring.dto.StudentDto;
import com.example.hw_java_spring.entity.Student;
import com.example.hw_java_spring.exception.ResourceNotFoundException;
import com.example.hw_java_spring.mapper.StudentMapper;
import com.example.hw_java_spring.repository.StudentRepository;
import com.example.hw_java_spring.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new RuntimeException("Student is not exist with given id: " +studentId));

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students =  studentRepository.findAll();
        return students.stream().map(student -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updateStudent) {

        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student is not exists with given id: "+ studentId)
        );

        student.setFirstName(updateStudent.getFirst_name());
        student.setLastName(updateStudent.getLast_name());
        student.setEmail(updateStudent.getEmail());
        student.setGender(updateStudent.getGender());

        Student updatedStudentOBJ =  studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updatedStudentOBJ);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student is not exists with given id: "+ studentId)
        );
        studentRepository.deleteById(studentId);

    }
}
