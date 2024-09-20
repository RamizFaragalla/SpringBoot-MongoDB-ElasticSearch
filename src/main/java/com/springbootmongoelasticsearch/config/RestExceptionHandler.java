package com.springbootmongoelasticsearch.config;

import com.springbootmongoelasticsearch.dtos.ErrorDto;
import com.springbootmongoelasticsearch.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorDto(e.getMessage()));
    }
}
