package com.peblo.QuizEngine.model;

import jakarta.persistence.*;

@Entity
public class StudentAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;

    private Long questionId;

    private String selectedAnswer;

    private Boolean correct;

    public Long getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}