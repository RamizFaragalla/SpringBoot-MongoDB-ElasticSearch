package com.springbootmongoelasticsearch.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class AppException extends RuntimeException {
    private HttpStatus httpStatus;

    public AppException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
