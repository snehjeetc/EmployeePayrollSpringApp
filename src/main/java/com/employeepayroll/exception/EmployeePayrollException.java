package com.employeepayroll.exception;

@SuppressWarnings("serial")
public class EmployeePayrollException extends RuntimeException{
	public 	enum EXCEPTION_TYPE{
		EMPLOYEE_NOT_FOUND
	}
	
	public final EXCEPTION_TYPE type;
	public EmployeePayrollException(String message, EXCEPTION_TYPE type) {
		super(message);
		this.type = type;
	}
}
