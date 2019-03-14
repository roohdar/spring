package com.cignex.movieticketbooking.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cignex.movieticketbooking.exception.MovieException.MovieAlreadyAwailabeException;
import com.cignex.movieticketbooking.exception.MovieException.MovieNotFoundException;
import com.cignex.movieticketbooking.model.ExceptionBean;

@RestController
@ControllerAdvice
public class MovieExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionBean exceptionBean = new ExceptionBean(new Date(), ex.getLocalizedMessage(),
				ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exceptionBean, HttpStatus.BAD_REQUEST);

	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionBean exceptionBean = new ExceptionBean(new Date(), ex.getLocalizedMessage(),
				request.getDescription(false).toString());
		return new ResponseEntity<Object>(exceptionBean, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(MovieAlreadyAwailabeException.class)
	protected ResponseEntity<Object> movieAlreadyAwailabeException(MovieAlreadyAwailabeException ex,
			WebRequest request) {
		System.err.println();

		ExceptionBean exceptionBean = new ExceptionBean(new Date(), ex.getLocalizedMessage(),
				request.getDescription(false).toString());
		return new ResponseEntity<Object>(exceptionBean, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(MovieNotFoundException.class)
	protected ResponseEntity<Object> movieNotFoundException(MovieNotFoundException ex, WebRequest request) {
		ExceptionBean exceptionBean = new ExceptionBean(new Date(), ex.getLocalizedMessage(),
				request.getDescription(false).toString());
		return new ResponseEntity<Object>(exceptionBean, HttpStatus.NOT_FOUND);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public static class MyFileNotFoundException extends RuntimeException {
		public MyFileNotFoundException(String message) {
			super(message);
		}

		public MyFileNotFoundException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	public static class FileStorageException extends RuntimeException {
		public FileStorageException(String message) {
			super(message);
		}

		public FileStorageException(String message, Throwable cause) {
			super(message, cause);
		}
	}

}
