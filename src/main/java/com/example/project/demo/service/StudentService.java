package com.example.project.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.demo.entity.StudentEntity;
import com.example.project.demo.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity queryById(Integer id) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            StudentEntity studentEntity = optional.get();
            return studentEntity;
        }
        return null;
    }

    public StudentEntity insert(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public List<StudentEntity> queryAll() {
        return studentRepository.findAll();
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

}
