package com.example.jpastudent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthDate;
    private LocalTime birthTime;


    public Student(int id, String name, LocalDate birthDate, LocalTime birthTime) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.birthTime = birthTime;
    }

    public Student() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalTime getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(LocalTime birthTime) {
        this.birthTime = birthTime;
    }
}
