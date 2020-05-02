package com.filipe.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.osworks.domain.model.Cliente;
import com.filipe.osworks.domain.repository.ClienteRepository;

@Service
public class ClienteCadastroService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}
}
