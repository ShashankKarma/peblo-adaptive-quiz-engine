package com.peblo.QuizEngine.dto;

public class Error {
    private String message;
    private int status;

    public Error(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage(){
        return message;
    }

    public int getStatus(){
        return status;
    }

}
