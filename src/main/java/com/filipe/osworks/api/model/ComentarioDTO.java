package com.filipe.osworks.api.model;

import java.time.OffsetDateTime;

import org.modelmapper.ModelMapper;

import com.filipe.osworks.domain.model.Comentario;

public class ComentarioDTO {
	
	private Integer id;
	
	private String descricao;
	
	private OffsetDateTime dhEnvio;
	
	public static ComentarioDTO asDto(Comentario comentario) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(comentario, ComentarioDTO.class);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public OffsetDateTime getDhEnvio() {
		return dhEnvio;
	}

	public void setDhEnvio(OffsetDateTime dhEnvio) {
		this.dhEnvio = dhEnvio;
	}
	
}
