package com.pisip.alondrabackend.presentacion.dto.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ServiciosExtraResponseDto {
	private int idServiciosExtra;
	private int idReserva;
	private float costo;
	private String tipoServicio;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
}
