package com.pisip.alondrabackend.presentacion.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HotelesReservasRequestDto {
	private int idHotelReserva;
	@NotNull
	private Integer idReserva;
	@NotNull
	private Integer idHotel;
	@NotNull
	private LocalDate fechaCheckin;
	@NotNull
	private LocalDate fechaCheckout;
	private LocalDate fechaExtraCheckin;
	private LocalDate fechaExtraCheckout;
}
