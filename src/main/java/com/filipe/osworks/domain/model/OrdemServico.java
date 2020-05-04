package com.filipe.osworks.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ORDEMSERVICO")
	private Integer id;
	
	@Column(name = "TX_DESCRICAO")
	private String descricao;

	@Column(name = "NU_PRECO")
	private BigDecimal preco;

	@Column(name = "DH_ABERTURA")
	private LocalDateTime dhAbertura;

	@Column(name = "DH_FINALIZACAO")
	private LocalDateTime dhFinalizacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "EN_STATUS")
	private StatusOrdemServico status;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private Cliente cliente;

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDateTime getDhAbertura() {
		return dhAbertura;
	}

	public void setDhAbertura(LocalDateTime dhAbertura) {
		this.dhAbertura = dhAbertura;
	}

	public LocalDateTime getDhFinalizacao() {
		return dhFinalizacao;
	}

	public void setDhFinalizacao(LocalDateTime dhFinalizacao) {
		this.dhFinalizacao = dhFinalizacao;
	}

	public StatusOrdemServico getStatus() {
		return status;
	}

	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
