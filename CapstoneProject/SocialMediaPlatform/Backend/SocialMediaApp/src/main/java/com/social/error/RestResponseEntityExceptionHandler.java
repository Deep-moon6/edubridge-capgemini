package com.social.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(GlobalExceptionHandler.class)
	public ResponseEntity<ErrorMessage> NotFoundException(GlobalExceptionHandler exceptionHandler, WebRequest request) {
	    ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exceptionHandler.getMessage());
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}
	
}