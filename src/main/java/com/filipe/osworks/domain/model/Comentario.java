package com.filipe.osworks.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comentario {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comentario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMENTARIO")
	private Integer id;
	
	@Column(name = "TX_DESCRICAO")
	private String descricao;
	
	@Column(name = "DH_ENVIO")
	private OffsetDateTime dhEnvio;

	@ManyToOne
	@JoinColumn(name = "ID_ORDEMSERVICO")
	private OrdemServico ordemServico;
	
	public Comentario() {
		super();
	}

	public Comentario(String descricao, OffsetDateTime dhEnvio) {
		super();
		this.descricao = descricao;
		this.dhEnvio = dhEnvio;
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

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
