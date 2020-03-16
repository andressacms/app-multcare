package br.edu.ufersa.multcare;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> notFoundError(Exception ex) {
    	return new ResponseEntity<String>("[Error] ".concat(ex.getMessage()),HttpStatus.BAD_GATEWAY);
    }

}