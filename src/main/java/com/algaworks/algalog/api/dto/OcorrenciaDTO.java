package com.algaworks.algalog.api.dto;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class OcorrenciaDTO {

	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
}
