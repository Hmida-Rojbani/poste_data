package tn.poste.data.project.rest.controllers.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExpHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  ResponseEntity<String> handleConstraintViolationException(IllegalArgumentException e) {
	    return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	  }

}
