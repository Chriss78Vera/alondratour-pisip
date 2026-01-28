package com.pisip.alondrabackend.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VuelosRequestDto {
	@NotBlank
	private  int idVuelo;
	@NotBlank
	private  String aerolinea;
	@NotBlank
	private  String origen;
	@NotBlank
	private  String destino;
	@NotBlank
	private  LocalDate fechaSalida;
	@NotBlank
	private  LocalDate fechaLlegada;
	private  LocalDate fechaExtraSalida;
	private  LocalDate fechaExtraLlegada;
}
