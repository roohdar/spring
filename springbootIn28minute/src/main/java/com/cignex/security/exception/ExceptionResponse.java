package com.cignex.security.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExceptionResponse {

	private Date timeStamp;
	private String message;
	private String details;

}
