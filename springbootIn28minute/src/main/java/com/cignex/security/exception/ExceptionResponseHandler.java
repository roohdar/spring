package com.cignex.security.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(new Date(), "Validation Failed",
				ex.getBindingResult().toString());
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}

}
