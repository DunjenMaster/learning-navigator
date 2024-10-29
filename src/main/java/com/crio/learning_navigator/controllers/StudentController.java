package com.crio.learning_navigator.controllers;

import com.crio.learning_navigator.entity.Student;
import com.crio.learning_navigator.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Student createStudent(@RequestBody Student student) {
//        return studentService.createStudent(student);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest.toStudent(),studentRequest.getSubjectIds());
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(id, studentRequest.toStudent(),studentRequest.getSubjectIds());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
