package com.cignex.springboot.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	MessageSource source;

	@ExceptionHandler(Myexception.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public final ErrorResponse handleUserNotFoundException(Myexception ex) {
		return new ErrorResponse(ex.getMessage(), ex.getCause().getMessage());
	}

}
