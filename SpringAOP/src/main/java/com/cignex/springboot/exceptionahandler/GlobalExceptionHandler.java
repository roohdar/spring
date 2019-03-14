package com.cignex.springboot.exceptionahandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Myexception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse errorResponse(Myexception e) {
		return new ErrorResponse("please write name", 500);
	}

}
