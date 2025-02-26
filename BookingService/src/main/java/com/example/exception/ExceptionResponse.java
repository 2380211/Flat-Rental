package com.example.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

	private Date timestamp ;
	private String message ;
	private String description ;
	
	public ExceptionResponse(Date timestamp, String message, String description) {
		super() ;
		this.timestamp = timestamp ;
		this.message = message ;
		this.description = description ;
		
	}
	
}
