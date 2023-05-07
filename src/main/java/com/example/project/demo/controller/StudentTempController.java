package com.example.project.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.demo.entity.StudentEntity;
import com.example.project.demo.entity.StudentRowMapper;

@RestController
public class StudentTempController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping("/student")
    public String insert(@RequestBody StudentEntity studentEntity) {
        String sql = "insert into Students(name, gender) values(:name, :gender)";
        Map<String, Object> map = new HashMap<>();
        map.put("name", studentEntity.getName());
        map.put("gender", studentEntity.getGender());
        KeyHolder Keyholder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), Keyholder);
        return "insert success";
    }

    @PutMapping("/student/batch")
    public String insertBatch(@RequestBody List<StudentEntity> studentList) {
        String sql = "insert into Students(name, gender) values(:name, :gender)";

        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[studentList.size()];
        for (int i = 0; i < studentList.size(); i++) {
            StudentEntity studentEntity = studentList.get(i);
            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("name", studentEntity.getName());
            parameterSources[i].addValue("gender", studentEntity.getGender());
        }
        namedParameterJdbcTemplate.batchUpdate(sql, parameterSources);
        return "batch success";
    }

    @DeleteMapping("student/{id}")
    public String delete(@PathVariable Integer id) {
        String sql = "delete from Students where id = :id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        namedParameterJdbcTemplate.update(sql, map);
        return "delete success";
    }

    @PutMapping("/student")
    public String update(@RequestBody StudentEntity studentEntity) {
        String sql = "update seuccess";
        return "update success";
    }

    @GetMapping("/student")
    public List<StudentEntity> queryAll() {
        String sql = "select id, name, gender from Students";
        Map<String, Object> map = new HashMap<>();
        List<StudentEntity> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
        return list;
    }

    @GetMapping("/student/{id}")
    public StudentEntity query(@PathVariable Integer id) {
        String sql = "select id, name, gender from Students where id = :id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<StudentEntity> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());

        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
