package com.algaworks.algalog.api.controller;

import java.util.List;

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

import com.algaworks.algalog.api.dto.DestinatarioDTO;
import com.algaworks.algalog.api.dto.EntregaDTO;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	
	@GetMapping
	public List<Entrega> listarEntregas() {
		return entregaRepository.findAll();
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaDTO> buscarEntregaPorId(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> {
					EntregaDTO entregaDTO = new EntregaDTO();
					entregaDTO.setId(entrega.getId());
					entregaDTO.setNomeCliente(entrega.getCliente().getNome());
					entregaDTO.setDestinatario(new DestinatarioDTO());
					entregaDTO.getDestinatario().setNome(entrega.getDestinatario().getNome());
					entregaDTO.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
					entregaDTO.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
					entregaDTO.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
					entregaDTO.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
					entregaDTO.setTaxa(entrega.getTaxa());
					entregaDTO.setStatus(entrega.getStatus());
					entregaDTO.setDataPedido(entrega.getDataPedido());
					entregaDTO.setDataFinalizado(entrega.getDataFinalizado());
					
					return ResponseEntity.ok(entregaDTO);
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		return solicitacaoEntregaService.solicitar(entrega);
	}
}
