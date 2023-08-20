package com.example.jpastudent.repo;

import com.example.jpastudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    //Student findByName(String name);
    List<Student> findAllByName(String name);
    List<Student> findByBirthDate(LocalDate date);
}
