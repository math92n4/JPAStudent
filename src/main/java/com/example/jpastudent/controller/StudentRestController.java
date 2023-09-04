package com.example.jpastudent.controller;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/studentid/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Student(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/student/{name}")
    public ResponseEntity<Student> getStudentsByName(@PathVariable String name) {
        Student student = studentRepository.findByName(name);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addstudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/addstudent/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()) {
            studentRepository.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletestudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted with id:" + id);
        } else {
            //return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

    }


    /*@GetMapping("/studentsdate/{date}")
    public List<Student> getStudentsByBirthDate(@PathVariable LocalDate date) {
        return studentRepository.findByBirthDate(date);
    }*/

    /*@GetMapping("/student/{name}")
    public Student getStudentByName(@PathVariable String name) {
        return studentRepository.findByName(name);
    }*/
}
