package com.student.exception;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	Date d1 = new Date();
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> exceptionFirst(NoSuchElementException e)
	{
		FormatException exception = new FormatException("Id not Found...","1000",d1.toString());
		return new ResponseEntity<FormatException> (exception,HttpStatus.BAD_REQUEST);
	}	
}
