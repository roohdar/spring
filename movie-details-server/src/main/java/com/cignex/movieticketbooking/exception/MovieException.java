package com.cignex.movieticketbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class MovieException {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public static class MovieNotFoundException extends RuntimeException {
		public MovieNotFoundException(String message) {
			super(message);
		}
	}

	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public static class MovieAlreadyAwailabeException extends IllegalArgumentException {

		public MovieAlreadyAwailabeException(String s) {
			super(s);
			// TODO Auto-generated constructor stub
		}

	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class FileStorageException extends RuntimeException {
		public FileStorageException(String message) {
			super(message);
		}

		public FileStorageException(String message, Throwable cause) {
			super(message, cause);
		}
	}

}