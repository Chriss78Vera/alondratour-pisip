package com.pisip.alondrabackend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgenciasRequestDto {
	private int idAgencia;

	@NotBlank
	private String nombre;

	@NotBlank
	private String telefono;

	private String email;
}
