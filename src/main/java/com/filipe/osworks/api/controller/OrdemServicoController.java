package com.filipe.osworks.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.osworks.api.model.OrdemServicoDTO;
import com.filipe.osworks.api.model.OrdemServicoInputDTO;
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
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<OrdemServicoDTO> listar(){
		return toListDto(ordemServicoRepository.findAll());
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrdemServicoDTO criar(@Valid @RequestBody OrdemServicoInputDTO ordemServicoInputDto) {
		OrdemServico ordemServico = toEntity(ordemServicoInputDto);
		
		return toDto(ordemServicoGestaoService.criar(ordemServico));
	}
	
	@GetMapping("{ordemServicoId}")
	public ResponseEntity<OrdemServicoDTO> buscar(@PathVariable Integer ordemServicoId) {
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);
				
		if(ordemServico.isPresent()) {
			//faz o mapeamento da OrdemServico para DTO
			OrdemServicoDTO ordemServicoDto = toDto(ordemServico.get());
			return ResponseEntity.ok().body(ordemServicoDto);			
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("{ordemServicoId}/finalizacao")
	public ResponseEntity<Void> finalizar(@PathVariable Integer ordemServicoId) {
		ordemServicoGestaoService.finalizar(ordemServicoId);
		
		return ResponseEntity.noContent().build();
	}
	
	//Método para a conversão de Entidade para DTO
	private OrdemServicoDTO toDto(OrdemServico ordemServico) {
		return modelMapper.map(ordemServico, OrdemServicoDTO.class);
	}
	
	private List<OrdemServicoDTO> toListDto(List<OrdemServico> ordens){
		return ordens.stream()
				.map(ordem -> toDto(ordem))
				.collect(Collectors.toList());
	}
	
	private OrdemServico toEntity(OrdemServicoInputDTO ordemServicoInputDto) {
		return modelMapper.map(ordemServicoInputDto, OrdemServico.class);
	}
}
