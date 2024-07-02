package com.example.demo.handler;

import com.example.demo.errors.ErrorResponse;
import com.example.demo.exceptions.ObjectNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotValidException.class)
    public ResponseEntity<?> handleException(Exception exp){

        HttpStatus status = HttpStatus.BAD_REQUEST; // 400

        ObjectNotValidException objectNotValidException = (ObjectNotValidException) exp;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exp.printStackTrace(printWriter);
        String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        objectNotValidException.getMessage(),
                        stackTrace,
                        objectNotValidException.getErrorMessages()
                ),
                status
        );
    }

}
