package com.filipe.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Classe que representa uma mensagem padrão de erro. 
 * Utilizada para a exibição de informações no tratamento de exceções capturadas na classe {@link ApiExceptionHandler}
 * */
public class MessageError {
	//status code
	private Integer status;
	
	//informações de data e hora de ocorrência do erro
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime dataHora;
	
	private String titulo;
	
	@JsonInclude(Include.NON_EMPTY)
	private List<Campo> campos;
	
	//classe interna que representará cada campo inválido.
	public static class Campo {
		private String atributo;
		private String mensagem;
		
		public Campo(String atributo, String mensagem) {
			super();
			this.atributo = atributo;
			this.mensagem = mensagem;
		}
		
		public String getAtributo() {
			return atributo;
		}

		public void setAtributo(String atributo) {
			this.atributo = atributo;
		}

		public String getMensagem() {
			return mensagem;
		}	
	}

	public MessageError(Integer status, LocalDateTime dataHora, String titulo, List<Campo> campos) {
		super();
		this.status = status;
		this.dataHora = dataHora;
		this.titulo = titulo;
		this.campos = campos;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
	
}
