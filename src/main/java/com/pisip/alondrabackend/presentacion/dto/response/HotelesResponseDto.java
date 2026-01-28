package com.pisip.alondrabackend.presentacion.dto.response;

import java.time.LocalDate;

import lombok.Data;
@Data
public class HotelesResponseDto {
	private int idHotel;
	private int idPaquetesDetalles;
	private String nombre;
	private LocalDate fechaCheckin;
	private LocalDate fechaCheckout;
	private LocalDate fechaExtraCheckin;
	private LocalDate fechaExtraCheckout;
}
