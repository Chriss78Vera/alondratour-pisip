package com.pisip.alondrabackend.presentacion.dto.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReservasResponseDto {

	private int idReserva;
	private int idUsuario;
	private LocalDate fechaReserva;
	private float costoTotal;
	private boolean estado;

	private AgenciasResponseDto agencia;
	private PaquetesResponseDto paquete;
	private VuelosResponseDto vuelo;
}
