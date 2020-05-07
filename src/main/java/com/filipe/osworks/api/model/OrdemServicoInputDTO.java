package com.filipe.osworks.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Classe que será utilizada no cadastro de ordens de serviço.
 * A quantidade limitada de atributos impede que o front-end envie informações 
 * como id, dhAbertura e dhFinalização, já que essas informações devem ser gerenciadas pela aplicação.
 * 
 * */
public class OrdemServicoInputDTO {
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	@NotNull
	@Valid //cascatear a validação para o atributo id presente na classe ClienteIdInputDTO
	private ClienteIdInputDTO cliente;

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

	public ClienteIdInputDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteIdInputDTO cliente) {
		this.cliente = cliente;
	}
	
}
