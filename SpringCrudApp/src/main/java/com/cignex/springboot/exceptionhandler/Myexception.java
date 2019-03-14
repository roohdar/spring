package com.cignex.springboot.exceptionhandler;

import lombok.Getter;

public class Myexception extends RuntimeException {

	@Getter
	private String msg;
	@Getter
	private Throwable throwable;

	private static final long serialVersionUID = 1L;

	public Myexception(String msg, Throwable throwable) {
		super(msg, throwable);
		this.throwable = throwable;
		this.msg = msg;
	}
}
