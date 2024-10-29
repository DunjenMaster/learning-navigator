package com.crio.learning_navigator.services;

import com.crio.learning_navigator.entity.Subject;
import com.crio.learning_navigator.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;


    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        return subject.orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    public Subject updateSubject(Long id, Subject updatedSubject) {
        Subject subject = getSubjectById(id);
        subject.setName(updatedSubject.getName());
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
