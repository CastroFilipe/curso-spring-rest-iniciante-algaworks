package com.filipe.osworks.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

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
	//@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private OffsetDateTime dataHora;
	
	private String titulo;
	
	@JsonInclude(Include.NON_EMPTY)
	private List<Campo> campos;
	
	//classe interna que representa um campo preenchido de forma inválida.
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

	public MessageError(Integer status, OffsetDateTime dataHora, String titulo, List<Campo> campos) {
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

	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(OffsetDateTime dataHora) {
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
