package com.filipe.osworks.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.filipe.osworks.domain.exception.EntidadeNaoEncontradaException;
import com.filipe.osworks.domain.exception.NegocioException;

/**
 * A classe fará, de forma global, o tratamento de exceções lançadas nas classes do pacote controller
 * 
 * ResponseEntityExceptionHandler classe que contém tratamento genérico e básico para algumas exceções.
 * */

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	//quando injetado, trará as informações de mensagens presentes no arquivo messages.properties
	@Autowired
	private MessageSource messageSource;
	
	//Executará o trecho de código quando a aplicação lançar a exceção especificada.
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<Object> handleEntidadeNaoEncontrada(NegocioException ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		MessageError mensagemDeErro = new MessageError(
				status.value(), 
				OffsetDateTime.now(), 
				ex.getMessage(), 
				null);
		
		return handleExceptionInternal(ex, mensagemDeErro, new HttpHeaders(), status, request);
	}
	
	//Executará o trecho de código quando a aplicação lançar a exceção especificada.
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		MessageError mensagemDeErro = new MessageError(
				status.value(), 
				OffsetDateTime.now(), 
				ex.getMessage(), 
				null);
		
		return handleExceptionInternal(ex, mensagemDeErro, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		//lista de campos
		List<MessageError.Campo> campos = new ArrayList<>();
		
		//percorrer por cada erro de validação presente na exceção
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nomeAtributo = ((FieldError)error).getField();
			
			campos.add(new MessageError.Campo(nomeAtributo, messageSource.getMessage(error, LocaleContextHolder.getLocale())));
		}
		
		MessageError mensagemDeErro = new MessageError(
				status.value(),
				OffsetDateTime.now(), 
				"Campo(s) preenchido(s) de forma incorreta",
				campos);
		
		return super.handleExceptionInternal(ex, mensagemDeErro, headers, status, request);
	}
}
