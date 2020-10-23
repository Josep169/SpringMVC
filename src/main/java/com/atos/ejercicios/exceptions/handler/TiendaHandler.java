package com.atos.ejercicios.exceptions.handler;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.atos.ejercicios.dto.ErrorDto;
import com.atos.ejercicios.exceptions.generic.NoContentException;
import com.atos.ejercicios.exceptions.generic.NotFoundException;
import com.atos.ejercicios.exceptions.generic.TiendaKOException;

@ControllerAdvice
public class TiendaHandler extends ResponseEntityExceptionHandler{
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({TiendaKOException.class})
	@ResponseBody
	public ErrorDto tiendaKO(HttpServletRequest request, TiendaKOException exception) {
		return new ErrorDto("00", exception.getDetalle());
	}
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({NotFoundException.class})
	@ResponseBody
	public ErrorDto notFoundRequest(HttpServletRequest request, NotFoundException exception) {
		System.out.println(exception.getLocalizedMessage());
		return new ErrorDto("01", exception.getLocalizedMessage());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler({NoContentException.class})
	@ResponseBody
	public ErrorDto notContentRequest(HttpServletRequest request, NoContentException exception) {
		return new ErrorDto("01", exception.getDetalle());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream().map( e -> e.getDefaultMessage()).collect(Collectors.toList());
		return new ResponseEntity<>(new ErrorDto("02", errorMessages.toString()),
				HttpStatus.BAD_REQUEST);
	}
}
