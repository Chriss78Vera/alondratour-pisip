package com.pisip.alondrabackend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgenciasRequestDto {
	@NotBlank
	private int idAgencia;

	@NotBlank
	private String nombre;

	@NotBlank
	private String telefono;
}
