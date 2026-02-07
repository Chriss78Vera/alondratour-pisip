package com.pisip.alondrabackend.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VuelosRequestDto {
	private int idVuelo;

	@NotNull
	private String aerolinea;

	@NotNull
	private Integer idPaisDestino;

	@NotNull
	private Integer idCiudadDestino;

	@NotNull
	private LocalDate fechaSalida;

	@NotNull
	private LocalDate fechaLlegada;

	private LocalDate fechaExtraSalida;
	private LocalDate fechaExtraLlegada;
}
