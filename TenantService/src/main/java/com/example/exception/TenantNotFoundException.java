package com.example.exception;

public class TenantNotFoundException extends Exception{

	public TenantNotFoundException(String message) {
		super(message) ;
	}
}
