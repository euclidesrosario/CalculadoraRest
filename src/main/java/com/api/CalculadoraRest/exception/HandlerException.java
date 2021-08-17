package com.api.CalculadoraRest.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	
	

	@ExceptionHandler({NumberFormatException.class})
	public ResponseEntity<Object> handleNumberFormatException(RuntimeException ex, WebRequest request) {
		
		String mensagemUsuario = messageSource.getMessage("parametro.invalido",null, LocaleContextHolder.getLocale());
		String mensagemTecnica = ex.toString();
		List<Erro>	erros = Arrays.asList(new Erro(mensagemUsuario,mensagemTecnica));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

		
	}
	
	@ExceptionHandler({NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerException(RuntimeException ex, WebRequest request) {
		
		String mensagemUsuario = messageSource.getMessage("recurso.nullo",null, LocaleContextHolder.getLocale());
		String mensagemTecnica = ex.toString();
		List<Erro>	erros = Arrays.asList(new Erro(mensagemUsuario,mensagemTecnica));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

		
	}
	
	@ExceptionHandler({ArithmeticException.class})
	public ResponseEntity<Object> handleArithmeticException(RuntimeException ex, WebRequest request) {
		
		String mensagemUsuario = messageSource.getMessage("operacao.invalida",null, LocaleContextHolder.getLocale());
		String mensagemTecnica = ex.toString();
		List<Erro>	erros = Arrays.asList(new Erro(mensagemUsuario,mensagemTecnica));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

		
	}
	
	
	// classe para mensagens de erro
	public static class Erro {
		String mensagemUsuario;
		String mensagemTecnica;
		
		public Erro(String mensagemUsuario, String mensagemTecnica) {
			
			this.mensagemUsuario = mensagemUsuario;
			this.mensagemTecnica = mensagemTecnica;
		}
		public String getMensagemUsuario() {
			return mensagemUsuario;
		}
		public String getMensagemTecnica() {
			return mensagemTecnica;
		}
		
	}

}
