package com.crio.learning_navigator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "subjects",fetch = FetchType.LAZY)
    private List<Student> students;

    @OneToMany(mappedBy = "subject")
    private List<Exam> exams;
}
