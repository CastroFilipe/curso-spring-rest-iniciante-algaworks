package com.filipe.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.osworks.domain.model.OrdemServico;
import com.filipe.osworks.domain.repository.OrdemServicoRepository;
import com.filipe.osworks.domain.service.OrdemServicoGestaoService;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoGestaoService ordemServicoGestaoService;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@GetMapping
	public List<OrdemServico> listar(){
		return ordemServicoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrdemServico criar(@Valid @RequestBody OrdemServico ordemServico) {
		return ordemServicoGestaoService.criar(ordemServico);
	}
	
	@GetMapping("{ordemServicoId}")
	public ResponseEntity<OrdemServico> buscar(@PathVariable Integer ordemServicoId) {
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);
				
		if(ordemServico.isPresent()) {
			return ResponseEntity.ok().body(ordemServico.get());			
		}
		
		return ResponseEntity.notFound().build();
	}
}
