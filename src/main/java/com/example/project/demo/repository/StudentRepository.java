package com.example.project.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.demo.entity.StudentEntity;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
    
}
