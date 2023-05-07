package com.example.project.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.demo.entity.StudentEntity;
import com.example.project.demo.repository.StudentRepository;

@RestController
public class StudentController {

    private StudentRepository studentRepository;

    @GetMapping("/students")
    public StudentEntity user() {
        StudentEntity student = new StudentEntity();
        student.setId(12);
        student.setName("HAHA");
        student.setGender("male");
        return student;
    }

    @PostMapping("/students")
    public String insert(@RequestBody StudentEntity studentEntity) {
        studentRepository.save(studentEntity);
        return "success";
    }

    @PutMapping("/students/{id}")
    public String update(@PathVariable Integer id, @RequestBody StudentEntity studentEntity) {
        StudentEntity student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(student.getName());
            student.setGender(student.getGender());
            studentRepository.save(student);

            return "update success";
        } else
            return "update fail";
    }

    @GetMapping("/students/{id}")
    public StudentEntity queryById(@PathVariable Integer id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
        return studentEntity;
    }
}
