package com.github.lf2a.library.exceptions;

import com.github.lf2a.library.models.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionModel bookNotFoundHandler(BookNotFoundException ex) {
        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setMessage(ex.getMessage());
        return exceptionModel;
    }
}
