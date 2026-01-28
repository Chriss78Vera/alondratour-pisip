package com.pisip.alondrabackend.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PasajerosRequestDto {
	
	@NotBlank
	private int idPasajero;
	@NotBlank
	private int idReserva;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotBlank
	private String cedula;
	@NotBlank
	private LocalDate fechaNacimiento;
	@NotBlank
	private boolean pasaporte;
	@NotBlank
	private boolean visa;

}
