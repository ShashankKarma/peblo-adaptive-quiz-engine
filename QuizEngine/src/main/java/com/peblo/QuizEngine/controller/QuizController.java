package com.peblo.QuizEngine.controller;

import com.peblo.QuizEngine.model.Question;
import com.peblo.QuizEngine.model.StudentAnswer;
import com.peblo.QuizEngine.repository.QuestionRepository;
import com.peblo.QuizEngine.service.QuizService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizController {

    private final QuizService quizService;
    private final QuestionRepository questionRepository;

    public QuizController(
            QuizService quizService,
            QuestionRepository questionRepository) {

        this.quizService = quizService;
        this.questionRepository = questionRepository;
    }

    // ------------------------------------------------
    // GENERATE QUIZ
    // ------------------------------------------------

    @PostMapping("/generate-quiz")
    public String generateQuiz() {

        quizService.generateQuizQuestions();

        return "Quiz generated successfully";
    }

   

    @GetMapping("/quiz")
    public List<Question> getQuiz(@RequestParam String difficulty) {

        return questionRepository.findByDifficulty(difficulty);
    }

   

    @PostMapping("/submit-answer")
    public StudentAnswer submitAnswer(
            @RequestParam String studentId,
            @RequestParam Long questionId,
            @RequestParam String selectedAnswer) {

        return quizService.submitAnswer(studentId, questionId, selectedAnswer);
    }
}