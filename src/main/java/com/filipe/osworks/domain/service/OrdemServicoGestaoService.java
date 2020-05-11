package com.filipe.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipe.osworks.domain.exception.EntidadeNaoEncontradaException;
import com.filipe.osworks.domain.model.Cliente;
import com.filipe.osworks.domain.model.Comentario;
import com.filipe.osworks.domain.model.OrdemServico;
import com.filipe.osworks.domain.model.StatusOrdemServico;
import com.filipe.osworks.domain.repository.ComentarioRepository;
import com.filipe.osworks.domain.repository.OrdemServicoRepository;

@Service
public class OrdemServicoGestaoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ClienteCadastroService clienteCadastroService;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDhAbertura(OffsetDateTime.now());
		
		Cliente cliente = clienteCadastroService.buscarPorId(ordemServico.getCliente().getId());
		ordemServico.setCliente(cliente);
		
		return ordemServicoRepository.save(ordemServico);
	}
	
	public Comentario adicionarComentario(Integer idOrdemServico, String descricao) {
		OrdemServico ordemServico = buscar(idOrdemServico);
		
		Comentario comentario = new Comentario(descricao, OffsetDateTime.now());
		comentario.setOrdemServico(ordemServico);
		return comentarioRepository.save(comentario);
	}

	public void finalizar(Integer idOrdemServico) {
		OrdemServico ordemServico = buscar(idOrdemServico);
		
		ordemServico.finalizar();
		
		ordemServicoRepository.save(ordemServico);
	}

	private OrdemServico buscar(Integer idOrdemServico) {
		return ordemServicoRepository.findById(idOrdemServico)
				.orElseThrow(()-> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada"));
	}
}
