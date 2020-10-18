package com.ing.exceptions;

import java.util.List;

import javax.validation.ConstraintViolation;

public class ValidationException extends RuntimeException{
	private String message;
	
	public ValidationException(List<ConstraintViolation> violations) {
		StringBuilder stackBuilder = new StringBuilder();
		for (ConstraintViolation violation : violations) {
			stackBuilder.append(violation.getMessage() + "\n");
		}
		message = stackBuilder.toString();
	}

	public String getMessage() {
		return message;
	}
}
