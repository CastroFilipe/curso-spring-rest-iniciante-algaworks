package com.filipe.osworks.api.model;

import javax.validation.constraints.NotNull;

/**
 * Classe DTO utilizada para receber o id do cliente no cadastro de ordens de servico através da
 * classe OrdemServicoInputDTO
 * */
public class ClienteIdInputDTO {
	
	@NotNull
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
