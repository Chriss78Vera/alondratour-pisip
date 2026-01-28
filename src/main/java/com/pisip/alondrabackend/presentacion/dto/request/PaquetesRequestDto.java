package com.pisip.alondrabackend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PaquetesRequestDto {
	@NotBlank
	private int idPaquete;

	@NotBlank
	private int idPaquetesDetalles;

	@NotBlank
	private String nombre;

	private String descripcion;

	@NotBlank
	private String pais;

	@NotBlank
	private String ciudad;
}
