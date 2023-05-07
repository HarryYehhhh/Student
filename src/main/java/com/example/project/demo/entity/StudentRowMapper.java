package com.example.project.demo.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<StudentEntity> {

    public StudentEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(resultSet.getInt("id"));
        studentEntity.setName(resultSet.getString("name"));
        studentEntity.setGender(resultSet.getString("gender"));

        return studentEntity;
    }
}
