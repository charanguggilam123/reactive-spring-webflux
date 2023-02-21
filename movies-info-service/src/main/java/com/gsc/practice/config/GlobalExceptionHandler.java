package com.gsc.practice.config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import com.gsc.practice.domain.Error;
import com.gsc.practice.exception.DBException;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(WebExchangeBindException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Mono<Error> webExchangeExceptionHandler(WebExchangeBindException ex){
		List<String> errorMessages = ex.getBindingResult().getAllErrors().stream().map(val->{
			System.out.println(val.getDefaultMessage());
			return val.getDefaultMessage();
		}).toList();
		return Mono.just(new Error(LocalDateTime.now(),errorMessages));
		
	}
	
	@ExceptionHandler(DBException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Mono<Error> dBExceptionHandler(DBException ex){
		
		return Mono.just(new Error(LocalDateTime.now(),List.of(ex.getMessage())));
		
	}

}
