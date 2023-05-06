package com.example.project.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.demo.entity.StudentEntity;

@RestController
public class StudentController {
    
    @GetMapping("/student")
    public StudentEntity user() {
        StudentEntity student = new StudentEntity();
        student.setId(12);
        student.setName("HAHA");
        student.setGender("male");
        return student;
    }
}
