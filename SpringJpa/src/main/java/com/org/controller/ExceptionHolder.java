package com.org.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.org.dto.Student;

@ControllerAdvice
public class ExceptionHolder {
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> myException(IdNotFoundException e){
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessege(e.getMessage());
		error.setStatus(404);
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
}
