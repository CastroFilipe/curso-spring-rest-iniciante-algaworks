package com.filipe.osworks.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.osworks.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@PersistenceContext //Semelhante ao @Autowired
	EntityManager manager;
	
	@GetMapping("/clientes")
	public List<Cliente> teste() {
		return manager.createQuery("from Cliente", Cliente.class).getResultList();
	}
}
