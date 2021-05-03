package com.employeepayroll.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employeepayroll.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollControllerValidation {

	private static final String message = "Exception while processing request";

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		List<String> errorMsgs = ex.getAllErrors().stream().map(error -> error.getDefaultMessage())
				.collect(Collectors.toList());
		return new ResponseEntity<>(new ResponseDTO(errorMsgs, message), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception) {
		ResponseDTO responseDto = new ResponseDTO(exception.getMessage(), message);
		return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException exception) {
		log.error("Invalid Date format", exception);
		ResponseDTO responseDto = new ResponseDTO("Should have date format in the format dd MMM yyyy", message);
		return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
	}
}
