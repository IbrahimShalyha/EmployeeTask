package com.employee.globalhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.customexception.SalaryNotFoundException;

@RestControllerAdvice
public class GlobalHandler {
	@ExceptionHandler(SalaryNotFoundException.class)
	public ResponseEntity<Object> salaryHandle() {
		return new ResponseEntity<Object>("SALARY DOES NOT EXIST", HttpStatus.BAD_REQUEST);
	}
}
