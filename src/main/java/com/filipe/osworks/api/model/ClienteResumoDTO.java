package com.filipe.osworks.api.model;

/**
 * Classe que contém apenas alguns dos atributos da entidade Cliente.
 * */
public class ClienteResumoDTO {
	
	private Integer id;
	
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
