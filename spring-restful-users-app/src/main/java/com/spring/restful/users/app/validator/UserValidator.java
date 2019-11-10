package com.spring.restful.users.app.validator;

import java.util.Arrays;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserValidator {

	@ExceptionHandler(value = NumberFormatException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ApiInputError handleNumberFormatException(NumberFormatException nfe) {
		ApiFieldError apiFieldError = new ApiFieldError("Id", "Please enter valid number");
		ApiInputError apiInputError = new ApiInputError("400-123", Arrays.asList(apiFieldError));
		return apiInputError;
	}

	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ApiInputError handleEmptyResultException(EmptyResultDataAccessException erdae) {
		ApiFieldError apiFieldError = new ApiFieldError("Id", "Resource not found");
		ApiInputError apiInputError = new ApiInputError("401-123", Arrays.asList(apiFieldError));
		return apiInputError;
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ApiError handleAnyOtherException(Exception ex) {
		ApiError apiError = new ApiError("500-123", Arrays.asList(ex.getLocalizedMessage()));
		return apiError;
	}
}
