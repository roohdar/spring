package com.cignex.springboot.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponse {

	private String message;
	private String throwable;
}
