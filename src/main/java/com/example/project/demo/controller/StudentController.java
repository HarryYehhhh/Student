package com.example.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.demo.entity.StudentEntity;
import com.example.project.demo.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

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
        studentService.insert(studentEntity);
        return "insert success";
    }

    @PutMapping("/students/{id}")
    public String update(@PathVariable Integer id, @RequestBody StudentEntity studentEntity) {
        StudentEntity student = studentService.queryById(id);
        if (student != null) {
            student.setName(student.getName());
            student.setGender(student.getGender());
            studentService.insert(student);

            return "update success";
        } else
            return "update fail";
    }

    @GetMapping("/students/{id}")
    public StudentEntity queryById(@PathVariable Integer id) {
        StudentEntity studentEntity = studentService.queryById(id);
        return studentEntity;
    }
}
