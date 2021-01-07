package com.github.willyancaetano.handler;


import com.github.willyancaetano.dto.ProblemResponseDto;
import com.github.willyancaetano.exception.HttpResponseException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = HttpResponseException.class)
    public ResponseEntity<Object> handleException(HttpResponseException exception, WebRequest request) {
        ProblemResponseDto problemResponseDto = exception.getProblemResponseDto();
        return ResponseEntity.status(problemResponseDto.getStatus())
            .contentType(MediaType.APPLICATION_PROBLEM_JSON)
            .body(problemResponseDto);
    }
}
