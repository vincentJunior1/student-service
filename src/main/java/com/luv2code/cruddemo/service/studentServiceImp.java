package com.luv2code.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.cruddemo.dao.StudentDAOImpl;
import com.luv2code.cruddemo.entity.Student;

@Service
public class studentServiceImp implements studentService {

    private StudentDAOImpl studentRepository;
    @Autowired
    public studentServiceImp(StudentDAOImpl studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        // TODO Auto-generated method stub
        studentRepository.save(student);

        Student result = studentRepository.findById(student.getId());
        return result;
    }

    @Override
    public Student update(Student student) {
        // TODO Auto-generated method stub
       studentRepository.update(student);
       Student result = studentRepository.findById(student.getId());

       return result;
    }

    @Override
    public void delete(int id) {
       Student student = studentRepository.findById(id);

       if (student.getId() == 0) {
            throw new RuntimeException("Did not find employee id - " + id);
            
       }

       studentRepository.delete(id);
    }

    

}