package com.pisip.alondrabackend.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class HotelesRequestDto {
	@NotBlank
	private int idHotel;
	@NotBlank
	private int idPaquetesDetalles;
	@NotBlank
	private String nombre;
	@NotBlank
	private LocalDate fechaCheckin;
	@NotBlank
	private LocalDate fechaCheckout;
	private LocalDate fechaExtraCheckin;
	private LocalDate fechaExtraCheckout;
}
