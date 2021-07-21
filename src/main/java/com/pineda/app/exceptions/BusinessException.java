package com.pineda.app.exceptions;

import lombok.Getter;

@Getter
public class BusinessException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private final String message;
	private final Integer status;
	
	
	
	public BusinessException(String message, Integer status) {
		super();
		this.message = message;
		this.status = status;
	}


}
