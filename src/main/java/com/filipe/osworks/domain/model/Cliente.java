package com.filipe.osworks.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.filipe.osworks.domain.validation.ValidationGroups;
/*
 * Classe Cliente(Persistence model). A classe possui classes DTOs de representação(Representation Model)
 * utilizadas no recebimento e envio de informações pela API.
 * As validações nos atributos desta classe(classe Persistence Model) se tornam opcionais pois as 
 * mesmas também estão presentes nas Classes DTOs(classes Representation Model) equivalentes.
 * 
 * */
@Entity
public class Cliente {

	@NotNull(groups = ValidationGroups.ClienteId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE")
	private Integer id;
	
	@NotBlank
	@Size(max = 60)
	@Column(name = "TX_NOME")
	private String nome;
	
	@NotBlank
	@Email
	@Size(max = 255)
	@Column(name = "TX_EMAIL")
	private String email;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "TX_FONE")
	private String telefone;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
