package com.algaworks.algalog.domain.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Destinatario {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String logradouro;
	
	@NotBlank
	private String numero;
	
	@NotBlank
	private String complemento;
			
	@NotBlank
	private String bairro;
}
