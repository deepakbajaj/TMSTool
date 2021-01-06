package com.tms.tmsserver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TaskIdException extends RuntimeException {
	
	public TaskIdException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
}
