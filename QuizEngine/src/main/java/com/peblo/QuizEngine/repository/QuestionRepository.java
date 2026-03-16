package com.peblo.QuizEngine.repository;

import com.peblo.QuizEngine.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByDifficulty(String difficulty);

}