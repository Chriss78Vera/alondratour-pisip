package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class HotelesReservas implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idHotelReserva;
	private final int idReserva;
	private final int idHotel;
	private final LocalDate fechaCheckin;
	private final LocalDate fechaCheckout;
	private final LocalDate fechaExtraCheckin;
	private final LocalDate fechaExtraCheckout;

	public HotelesReservas(int idHotelReserva, int idReserva, int idHotel,
			LocalDate fechaCheckin, LocalDate fechaCheckout,
			LocalDate fechaExtraCheckin, LocalDate fechaExtraCheckout) {
		this.idHotelReserva = idHotelReserva;
		this.idReserva = idReserva;
		this.idHotel = idHotel;
		this.fechaCheckin = fechaCheckin;
		this.fechaCheckout = fechaCheckout;
		this.fechaExtraCheckin = fechaExtraCheckin;
		this.fechaExtraCheckout = fechaExtraCheckout;
	}

	public int getIdHotelReserva() {
		return idHotelReserva;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public LocalDate getFechaCheckin() {
		return fechaCheckin;
	}

	public LocalDate getFechaCheckout() {
		return fechaCheckout;
	}

	public LocalDate getFechaExtraCheckin() {
		return fechaExtraCheckin;
	}

	public LocalDate getFechaExtraCheckout() {
		return fechaExtraCheckout;
	}
}
