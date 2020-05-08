package com.filipe.osworks.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.osworks.api.model.ComentarioDTO;
import com.filipe.osworks.api.model.ComentarioInputDTO;
import com.filipe.osworks.domain.model.Comentario;
import com.filipe.osworks.domain.service.OrdemServicoGestaoService;

@RestController
@RequestMapping("ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {

	@Autowired
	private OrdemServicoGestaoService ordemServicoGestaoService;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ComentarioDTO adicionar(
			@PathVariable Integer ordemServicoId, 
			@Valid @RequestBody ComentarioInputDTO comentarioInputDTO) {
		
		Comentario comentario = ordemServicoGestaoService
				.adicionarComentario(ordemServicoId, comentarioInputDTO.getDescricao());
		
		return ComentarioDTO.asDto(comentario);
	}
	
}
