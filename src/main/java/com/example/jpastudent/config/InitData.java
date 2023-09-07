package com.example.jpastudent.config;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Student student = new Student();
        student.setName("Mathias");
        student.setBirthDate(LocalDate.of(1998,8,29));
        student.setBirthTime(LocalTime.of(6,11,12));

        Student student1 = new Student();
        student1.setName("Mads");
        student1.setBirthDate(LocalDate.of(1990,11,7));
        student1.setBirthTime(LocalTime.of(7,14,21));

        studentRepository.save(student);
        studentRepository.save(student1);
        //
    }
}


    /*  Hvad sker der hvis vi skriver følgende kode ?

        Student s1 = new Student();
        s1.setName("Bruce");
        s1.setBornDate(LocalDate.of(2010, 11, 12));
        s1.setBornTime(LocalTime.of(10,11,12));
        studentRepository.save(s1);
        studentRepository.save(s1);
        studentRepository.save(s1);

        Objektet har samme hashværdi og gemmes derfor ikke i db

        Prøv at ændre navnet til noget andet, og se hvad der sker i databasen. Hvad er det for en type sql der bliver udført?

        Student objektets navn ændres til det nylig satte navn. Vel en form for transaktion, hvor der først bliver persisted,
        når hele koden er kørt igennem succesfuldt, og derfor gemmer den sidste linje, hvor navnet er sat til noget andet?

    */