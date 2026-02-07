package com.pisip.alondrabackend.presentacion.dto.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VuelosResponseDto {
	private int idVuelo;
	private String aerolinea;
	private int idPaisDestino;
	private int idCiudadDestino;
	private String nombrePaisDestino;
	private String nombreCiudadDestino;
	private LocalDate fechaSalida;
	private LocalDate fechaLlegada;
	private LocalDate fechaExtraSalida;
	private LocalDate fechaExtraLlegada;
}
