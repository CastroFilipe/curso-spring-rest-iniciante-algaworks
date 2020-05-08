package com.filipe.osworks.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.filipe.osworks.domain.validation.ValidationGroups;

@Entity
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ORDEMSERVICO")
	private Integer id;
	
	@Column(name = "TX_DESCRICAO")
	@NotBlank
	private String descricao;
	
	@Column(name = "NU_PRECO")
	@NotNull
	private BigDecimal preco;

	/*
	 * Propriedade que impedirá que dados não necessários sejam preenchidos e enviados do front.
	 * Por exemplo, as data de abertura e de finalização devem ser gerenciada pela aplicação,
	 * sem o valor READ_ONLY essas datas poderiam ser preenchidas e enviadas pelo front, na requisição.
	 * */
	@JsonProperty(access = Access.READ_ONLY)
	@Column(name = "DH_ABERTURA")
	private OffsetDateTime dhAbertura;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Column(name = "DH_FINALIZACAO")
	private OffsetDateTime dhFinalizacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "EN_STATUS")
	@JsonProperty(access = Access.READ_ONLY)
	private StatusOrdemServico status;
	
	/*
	 * A anotação @NotNull impedirá que Cliente == null no cadastro de ordens de serviço. 
	 * Porém não é feita a validação do id do cliente. Ainda será possível passar um Cliente com id == null.
	 * 
	 * A anotação @Valid resolverá esse problema, permitindo a validação em cascata.
	 * A validação em cascata fará a validação do id do cliente que, internamente ao objeto, 
	 * está anotado com @NotNull. Porém outros campos, não necessários no cadastro de OS, além do id, 
	 * também serão validados em cascata. 
	 * 
	 * Para especificar que apenas o ID do Cliente deve ser validado no cadastro de OS será utilizado o
	 * @ConvertGroup. A anotação retira o grupo Default e utiliza o groupo ClienteId.class.
	 * O id do cliente deverá ser anotado com @NotNull(groups = ValidationGroups.ClienteId.class).
	 * Com isso, somente o ID do cliente será validado em cascata.
	 * */
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	@Valid
	@ConvertGroup(from = Default.class , to = ValidationGroups.ClienteId.class)
	@NotNull
	private Cliente cliente;
	
	@OneToMany(mappedBy = "ordemServico")
	private List<Comentario> comentarios = new ArrayList<>();

	public OrdemServico() {
		super();
	}

	public OrdemServico(Integer id) {
		super();
		this.id = id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
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
