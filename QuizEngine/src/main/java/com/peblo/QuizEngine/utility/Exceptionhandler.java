package com.peblo.QuizEngine.utility;

import com.peblo.QuizEngine.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class Exceptionhandler {

    @ExceptionHandler(Exception.class)
    public Error handleException(Exception ex) {

        return new Error(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
    }
}
