package com.filipe.osworks.api.model;

import javax.validation.constraints.NotBlank;

import org.modelmapper.ModelMapper;

import com.filipe.osworks.domain.model.Comentario;

public class ComentarioInputDTO {
	
	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Comentario toEntity() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(this, Comentario.class);
	}

}
