package com.filipe.osworks.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.osworks.domain.model.Cliente;
import com.filipe.osworks.domain.repository.ClienteRepository;

@RestController
public class ClienteController {
	
//	@PersistenceContext //Semelhante ao @Autowired
//	EntityManager manager;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> teste() {
		//return manager.createQuery("from Cliente", Cliente.class).getResultList();
		return clienteRepository.findAll();
	}
}
