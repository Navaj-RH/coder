package com.te.employeemanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;import com.te.employeemanagement.dto.ResponseDto;
import com.te.employeemanagement.exception.ResoucesNotFoundException;

@RestControllerAdvice
public class EmployeeExceptionController {

	@ExceptionHandler(ResoucesNotFoundException.class)
	public ResponseEntity<?> employeeExceptionHandeler(ResoucesNotFoundException notFoundException) {
		return new ResponseEntity<>(notFoundException.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
