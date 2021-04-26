package com.employeepayroll.dto;

public class ResponseDTO {
	public Object data;
	public String message;
	
	public ResponseDTO(Object data, String message) {
		this.data = data;
		this.message = message;
	}
}
