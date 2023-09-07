package com.example.jpastudent.repo;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repo.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class JpaStudentApplicationTests {



    @Autowired
    StudentRepository studentRepository;

    /*@Test
    void testOneMathias() {
        List<Student> list = studentRepository.findAllByName("Mathias");
        assertEquals(1, list.size());
    }*/

    @Test
    void contextLoads() {
    }

    @Test
    void testOneViggo() {
        Student student = new Student();
        student.setName("Viggo");
        student.setBirthDate(LocalDate.now());
        studentRepository.save(student);
        var list = studentRepository.findAllByName("Viggo");
        assertEquals(1,list.size());
    }

}
