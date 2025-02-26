package com.example.exception;

import java.util.Date;

import lombok.Data;

@Data
public class ExceptionResponse {

	Date timestamp ;
	String message ;
	String description ;
	
	public ExceptionResponse(Date timestamp, String message, String description) {
		super() ;
		this.timestamp = timestamp ;
		this.message = message ;
		this.description = description ;
		
	}
	
}
