package com.cignex.movieticketbooking.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionBean {

	private Date timeStamp;
	private String message;
	private String details;

}
