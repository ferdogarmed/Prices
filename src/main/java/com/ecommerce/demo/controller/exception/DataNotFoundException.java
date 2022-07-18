package com.ecommerce.demo.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {

	private final static String NOT_FOUND_MSG = "Data not Found";

	public DataNotFoundException() {
		super(NOT_FOUND_MSG);
	}
}
