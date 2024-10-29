package com.crio.learning_navigator.services;

import com.crio.learning_navigator.entity.Exam;
import com.crio.learning_navigator.repositories.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam saveExam(Exam exam){
        return examRepository.save(exam);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam getExamById(Long id) {
        Optional<Exam> exam = examRepository.findById(id);
        return exam.orElseThrow(() -> new RuntimeException("Exam not found"));
    }

    public Exam updateExam(Long id, Exam updatedExam) {
        Exam exam = getExamById(id);
        exam.setName(updatedExam.getName());
        exam.setDate(updatedExam.getDate());
        return examRepository.save(exam);
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}
