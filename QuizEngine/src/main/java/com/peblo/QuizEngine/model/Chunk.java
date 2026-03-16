package com.peblo.QuizEngine.model;

import jakarta.persistence.*;

@Entity
public class Chunk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceId;

    private String chunkId;

    private Integer grade;

    private String subject;

    private String topic;

    @Column(length = 5000)
    private String text;

    public Long getId() {
        return id;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getChunkId() {
        return chunkId;
    }

    public Integer getGrade() {
        return grade;
    }

    public String getSubject() {
        return subject;
    }

    public String getTopic() {
        return topic;
    }

    public String getText() {
        return text;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setChunkId(String chunkId) {
        this.chunkId = chunkId;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setText(String text) {
        this.text = text;
    }
}