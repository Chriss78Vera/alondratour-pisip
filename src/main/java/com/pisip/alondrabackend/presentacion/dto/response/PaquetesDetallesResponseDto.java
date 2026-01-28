package com.pisip.alondrabackend.presentacion.dto.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PaquetesDetallesResponseDto {
	private int idPaquetesDetalles;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private float precioNeto;
}
