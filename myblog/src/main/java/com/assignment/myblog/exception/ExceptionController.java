package com.assignment.myblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodValidException(MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = makeErrorResponse(e.getBindingResult());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }   // ????????????? ㅁ?ㄹ

    private ErrorResponse makeErrorResponse(BindingResult bindingResult) {
        String description = "";
        String detail = "";

        //에러가 있다면
        if (bindingResult.hasErrors()) {
            //DTO에 설정한 message값을 가져온다
            detail = bindingResult.getFieldError().getDefaultMessage();
            description = ErrorCode.NOT_EMPTY.getDescription();

        }

        return new ErrorResponse(description, detail);
    }
}

