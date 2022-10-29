package com.ttinder.ttinder.controller;

import com.ttinder.ttinder.exception.RequestException;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestApiExceptionHandler {
    @ExceptionHandler(value = { RequestException.class })
    public ResponseEntity<ResponseDto<Object>> handleApiRequestException(RequestException e) {

        return new ResponseEntity<>(ResponseDto.fails(
                e.getHttpStatus(),
                e.getMessage()), e.getHttpStatus()
        );
    }

}
