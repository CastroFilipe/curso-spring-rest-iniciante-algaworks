package com.filipe.osworks.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.filipe.osworks.domain.model.StatusOrdemServico;

public class OrdemServicoDTO {
	
	private Integer id;	
	private String descricao;
	private BigDecimal preco;
	private OffsetDateTime dhAbertura;
	private OffsetDateTime dhFinalizacao;
	private StatusOrdemServico status;
	private ClienteResumoDTO cliente;
	
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
	
	public OffsetDateTime getDhAbertura() {
		return dhAbertura;
	}
	
	public void setDhAbertura(OffsetDateTime dhAbertura) {
		this.dhAbertura = dhAbertura;
	}
	
	public OffsetDateTime getDhFinalizacao() {
		return dhFinalizacao;
	}
	
	public void setDhFinalizacao(OffsetDateTime dhFinalizacao) {
		this.dhFinalizacao = dhFinalizacao;
	}
	
	public StatusOrdemServico getStatus() {
		return status;
	}
	
	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}

	public ClienteResumoDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResumoDTO cliente) {
		this.cliente = cliente;
	}
	
}
