package com.pisip.alondrabackend.presentacion.dto.response;

import java.time.LocalDate;

import lombok.Data;
@Data
public class VuelosResponseDto {
	private  int idVuelo;
	private  String aerolinea;
	private  String origen;
	private  String destino;
	private  LocalDate fechaSalida;
	private  LocalDate fechaLlegada;
	private  LocalDate fechaExtraSalida;
	private  LocalDate fechaExtraLlegada;
}
