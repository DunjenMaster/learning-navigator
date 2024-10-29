package com.crio.learning_navigator.controllers;

import com.crio.learning_navigator.entity.Exam;
import com.crio.learning_navigator.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

//    @PostMapping("/exams")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Exam createExam(@RequestBody Exam exam) {
//        return examService.createExam(exam);
//    }

//    @PostMapping
//    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
//        Exam savedExam = examService.saveExam(exam);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedExam);
//    }

    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        Exam savedExam = examService.saveExam(exam);
        return new ResponseEntity<>(savedExam, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return examService.getExamById(id);
    }

    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody Exam exam) {
        return examService.updateExam(id, exam);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
    }
}
