package com.algaworks.algalog.api.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class OcorrenciaInput {

	@NotBlank
	private String descricao;
}
