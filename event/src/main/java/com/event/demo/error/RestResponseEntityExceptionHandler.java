package com.event.demo.error;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.event.demo.exceptions.SuperUserAlreadyExistException;
import com.event.demo.exceptions.SuperUserException;
import com.event.demo.exceptions.SuperUserNotFoundException;


@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(SuperUserNotFoundException.class)
	public ResponseEntity<ErrorMessage> superUserNotFoundException(SuperUserNotFoundException exception,WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	@ExceptionHandler(SuperUserAlreadyExistException.class)
	public ResponseEntity<ErrorMessage> superUserAlreadyExist(SuperUserAlreadyExistException exception , WebRequest request){
		ErrorMessage message = new ErrorMessage(HttpStatus.FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.FOUND).body(message);
	}
	@ExceptionHandler(SuperUserException.class)
	public ResponseEntity<ErrorMessage> superUserFirstNameNotFound(SuperUserException exception, WebRequest request){
		ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST,exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
