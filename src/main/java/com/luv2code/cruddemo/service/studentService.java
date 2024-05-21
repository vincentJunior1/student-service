package com.luv2code.cruddemo.service;

import java.util.List;

import com.luv2code.cruddemo.entity.Student;

public interface studentService {
    List<Student> findAll();
    Student save(Student student);
    Student update(Student student);
    void delete(int id);
}
