package com.crio.learning_navigator.repositories;

import com.crio.learning_navigator.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;


public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
