package com.pisip.alondrabackend.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PaquetesDetallesRequestDto {
	@NotBlank
	private int idPaquetesDetalles;

	@NotBlank
	private LocalDate fechaInicio;

	@NotBlank
	private LocalDate fechaFin;

	@NotBlank
	private float precioNeto;
}
