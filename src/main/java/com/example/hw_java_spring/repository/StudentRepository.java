package com.example.hw_java_spring.repository;

import com.example.hw_java_spring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long > {
}
