package com.crio.learning_navigator.controllers;

import com.crio.learning_navigator.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentRequest {
    private String name;
    private int age;
    private String email;
    private List<Long> subjectIds;


    public Student toStudent() {
        Student student = new Student();
        student.setName(this.name);
        student.setAge(this.age);
        student.setEmail(this.email);
        return student;
    }
}
