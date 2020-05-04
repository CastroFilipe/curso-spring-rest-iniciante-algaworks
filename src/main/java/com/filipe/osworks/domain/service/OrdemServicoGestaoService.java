package com.filipe.osworks.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.osworks.domain.model.Cliente;
import com.filipe.osworks.domain.model.OrdemServico;
import com.filipe.osworks.domain.model.StatusOrdemServico;
import com.filipe.osworks.domain.repository.OrdemServicoRepository;

@Service
public class OrdemServicoGestaoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ClienteCadastroService clienteCadastroService;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDhAbertura(LocalDateTime.now());
		
		Cliente cliente = clienteCadastroService.buscarPorId(ordemServico.getCliente().getId());
		ordemServico.setCliente(cliente);
		
		return ordemServicoRepository.save(ordemServico);
	}
}
