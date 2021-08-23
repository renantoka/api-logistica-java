package com.algaworks.algalog.api.dto.input;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class DestinatarioInput {

	@NotBlank
	@Column(name = "destinatario_nome")
	private String nome;
	
	@NotBlank
	@Column(name = "destinatario_logradouro")
	private String logradouro;
	
	@NotBlank
	@Column(name = "destinatario_numero")
	private String numero;
	
	@NotBlank
	@Column(name = "destinatario_complemento")
	private String complemento;
			
	@NotBlank
	@Column(name = "destinatario_bairro")
	private String bairro;
}
