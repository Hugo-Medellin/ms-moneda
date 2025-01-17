package com.venture.soft.ms_moneda.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.venture.soft.ms_moneda.Dto.DtoResponse;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<DtoResponse<String>> handleEntityNotFoundException(EntityNotFoundException ex) {
		DtoResponse<String> response = new DtoResponse<String>(404, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<DtoResponse<String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		DtoResponse<String> response = new DtoResponse<String>(400, "Requerido el cuerpo en la petición.");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<DtoResponse<String>> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
		DtoResponse<String> response = new DtoResponse<String>(405, "Metódo no permitido.");
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<DtoResponse<String>> handleNoResourceFoundException(NoResourceFoundException ex) {
		DtoResponse<String> response = new DtoResponse<String>(404, "Recurso no encontrado.");
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}