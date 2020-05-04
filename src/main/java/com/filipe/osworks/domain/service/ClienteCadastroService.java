package com.filipe.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.osworks.domain.exception.NegocioException;
import com.filipe.osworks.domain.model.Cliente;
import com.filipe.osworks.domain.repository.ClienteRepository;

@Service
public class ClienteCadastroService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscarPorId(Integer id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		return cliente;
	}
	
	public Cliente salvar(Cliente cliente) {
		clienteRepository.findByEmail(cliente.getEmail())
			.ifPresent((clienteExistente) -> {
				//se os ids forem diferentes, indica que não é um update de um registro no bd.
				if(clienteExistente.getId() != cliente.getId()) {
					throw new NegocioException("Já existe um cliente cadastrado com esse email");
				}
			});
		
		return clienteRepository.save(cliente);
	}

	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}
}
