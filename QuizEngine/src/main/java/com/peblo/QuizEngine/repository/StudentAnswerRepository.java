package com.peblo.QuizEngine.repository;

import com.peblo.QuizEngine.model.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, Long> {

    List<StudentAnswer> findByStudentId(String studentId);

}