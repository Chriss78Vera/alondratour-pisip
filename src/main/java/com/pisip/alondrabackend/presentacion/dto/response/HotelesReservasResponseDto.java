package com.pisip.alondrabackend.presentacion.dto.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class HotelesReservasResponseDto {
	private int idHotelReserva;
	private int idReserva;
	private int idHotel;
	private LocalDate fechaCheckin;
	private LocalDate fechaCheckout;
	private LocalDate fechaExtraCheckin;
	private LocalDate fechaExtraCheckout;
	/** Datos completos del hotel (idHotel, idPaquetesDetalles, nombre, precio). */
	private HotelesResponseDto hotel;
}
