package com.employeepayroll.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employeepayroll.dto.ResponseDTO;


@ControllerAdvice
public class EmployeePayrollControllerValidation extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request) {
		List<String> errorMsgs = ex.getAllErrors()
				.stream()
				.map(error -> error.getDefaultMessage())
				.collect(Collectors.toList());
		return new ResponseEntity<>(
				new ResponseDTO(errorMsgs, "Encountered errors"),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayrollException(
					EmployeePayrollException exception){
		ResponseDTO responseDto = new ResponseDTO("Exception while processing request", 
				exception.getMessage());
		return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
	}
}
