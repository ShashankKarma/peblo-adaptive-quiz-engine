package com.peblo.QuizEngine.model;

import jakarta.persistence.*;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String subject;

    private Integer grade;

    public Long getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
