package com.pisip.alondrabackend.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReservasRequestDto {
	
	@NotBlank
	private int idReserva;
	@NotBlank
	private int idUsuario;
	@NotBlank
	private int idVuelo;
	@NotBlank
	private int idPaquete;
	@NotBlank
	private int idAgencia;
	@NotBlank
	private LocalDate fechaReserva;
	@NotBlank
	private float costoTotal;
	@NotBlank
	private boolean estado;

}
