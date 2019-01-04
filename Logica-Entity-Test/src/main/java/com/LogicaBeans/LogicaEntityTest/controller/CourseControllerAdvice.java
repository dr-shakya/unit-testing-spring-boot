package com.LogicaBeans.LogicaEntityTest.controller;


import com.LogicaBeans.LogicaEntityTest.dto.ErrorDetails;
import com.LogicaBeans.LogicaEntityTest.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(value = "com.LogicaBeans.LogicaEntityTest")
public class CourseControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ErrorDetails> courseNotFoundHandler(ResourceNotFoundException e, HttpServletRequest req){
        ErrorDetails errorDetails= new ErrorDetails(e.getMessage(), req.getRequestURI());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
