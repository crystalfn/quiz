package com.twuc.shopping.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({
        ProductExitsException.class
    })
    public ResponseEntity<CommentError> handleException(Exception error) {
        CommentError commentError = new CommentError();
        commentError.setErrorMessage(error.getMessage());
        return ResponseEntity.badRequest().body(commentError);
    }
}
