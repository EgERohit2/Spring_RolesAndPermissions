package com.roles.permission.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	@ResponseBody
	ErrorMessage handleAccessDeniedException(AccessDeniedException e) {
		ErrorMessage em = new ErrorMessage();
		em.setMessage("access deneied");
		em.setMessageKey("request invalid");
		return em;
	}
}
