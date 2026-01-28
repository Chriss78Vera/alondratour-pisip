package com.pisip.alondrabackend.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ServiciosExtraRequestDto {
	@NotBlank
	private int idServiciosExtra;

	@NotBlank
	private int idReserva;

	@NotBlank
	private float costo;

	@NotBlank
	private String tipoServicio;

	@NotBlank
	private LocalDate fechaInicio;

	@NotBlank
	private LocalDate fechaFin;
}
