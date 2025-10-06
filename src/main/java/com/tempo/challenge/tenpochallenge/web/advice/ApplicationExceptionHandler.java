package com.tempo.challenge.tenpochallenge.web.advice;

import com.tempo.challenge.tenpochallenge.exception.ClientException;
import com.tempo.challenge.tenpochallenge.model.dto.TenpoExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = ClientException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public TenpoExceptionResponse clientException(ClientException ex) {
        return TenpoExceptionResponse.builder()
            .code(ex.getCode())
            .message(ex.getMessage())
            .build();
    }
}
