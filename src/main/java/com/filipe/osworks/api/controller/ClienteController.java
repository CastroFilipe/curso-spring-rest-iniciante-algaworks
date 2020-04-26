package com.filipe.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.osworks.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> teste() {
		Cliente c1 = new Cliente(1L, "João", "joao@exemplo.com", "1234567");
		Cliente c2 = new Cliente(2L, "Paula", "paula@exemplo.com", "987456");

		return Arrays.asList(c1, c2);
	}
}
