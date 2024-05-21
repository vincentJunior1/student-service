package com.luv2code.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.service.studentServiceImp;

@RestController
@RequestMapping("/api")
public class studentRest {

    private studentServiceImp studentService;

    @Autowired
    public studentRest(studentServiceImp studentService){
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<Student> findAll(){
        return studentService.findAll();
    }
    @PostMapping("/student")
    public Student SaveStudent(@RequestBody Student student){
        student.setId(0);

        Student result = studentService.save(student);
        return result;
    }

    @PutMapping("/student")
    public Student UpdateStudent(@RequestBody Student student){
        Student result = studentService.update(student);

        return result;
    }

    @DeleteMapping("/student/{studentId}")
    public String DeleteStudent(@PathVariable int studentId){
        studentService.delete(studentId);
        return "Success";
    }
}
