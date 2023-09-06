package com.employee.customexception;

public class SalaryNotFoundException extends Exception {
	public SalaryNotFoundException(String msg) {
		super(msg);
	}
}
