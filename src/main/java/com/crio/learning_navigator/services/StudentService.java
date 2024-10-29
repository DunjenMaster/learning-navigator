package com.crio.learning_navigator.services;

import com.crio.learning_navigator.entity.Student;
import com.crio.learning_navigator.entity.Subject;
import com.crio.learning_navigator.repositories.StudentRepository;
import com.crio.learning_navigator.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public Student createStudent(Student student, List<Long> subjectIds) {
        List<Subject> subjects = subjectRepository.findAllById(subjectIds);
        student.setSubjects(subjects);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElseThrow(() -> new RuntimeException("Student not found"));
    }

//    public Student updateStudent(Long id, Student updatedStudent) {
//        Student student = getStudentById(id);
//        student.setName(updatedStudent.getName());
//        student.setAge(updatedStudent.getAge());
//        return studentRepository.save(student);
//    }

    public Student updateStudent(Long id, Student student, List<Long> subjectIds){
        Student existingStudent = getStudentById(id);
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());

        List<Subject> subjects = subjectRepository.findAllById(subjectIds);
        existingStudent.setSubjects(subjects);

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
