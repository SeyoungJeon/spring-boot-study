package com.navercorp.bookserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import javax.ws.rs.core.Response;

@ControllerAdvice
public class GlobalExceptionHandler implements ProblemHandling {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Problem> handleNullPointerException (
            NullPointerException exception,
            NativeWebRequest request) throws HttpMediaTypeNotAcceptableException {
        return create(Response.Status.NOT_FOUND, exception, request);
    }
}