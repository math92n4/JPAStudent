package com.example.jpastudent.controller;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
        var list = studentRepository.findAll();
        //List<Student> students = studentRepository.findAll();
        return list;
    }

    @GetMapping("/addstudent")
    public List<Student> addStudent() {
        Student student = new Student();
        student.setBirthDate(LocalDate.now());
        studentRepository.save(student);
        var list = studentRepository.findAll();
        return list;
    }


    @GetMapping("/students/{name}")
    public List<Student> getStudentsByName(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }

    @GetMapping("/studentsdate/{date}")
    public List<Student> getStudentsByBirthDate(@PathVariable LocalDate date) {
        return studentRepository.findByBirthDate(date);
    }

    /*@GetMapping("/student/{name}")
    public Student getStudentByName(@PathVariable String name) {
        return studentRepository.findByName(name);
    }*/
}
