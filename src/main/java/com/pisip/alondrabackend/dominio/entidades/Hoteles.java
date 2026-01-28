package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class Hoteles implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idHotel;
	private final int idPaquetesDetalles;
	private final String nombre;
	private final LocalDate fechaCheckin;
	private final LocalDate fechaCheckout;
	private final LocalDate fechaExtraCheckin;
	private final LocalDate fechaExtraCheckout;

	public Hoteles(int idHotel, int idPaquetesDetalles, String nombre, LocalDate fechaCheckin,
			LocalDate fechaCheckout, LocalDate fechaExtraCheckin, LocalDate fechaExtraCheckout) {
		super();
		this.idHotel = idHotel;
		this.idPaquetesDetalles = idPaquetesDetalles;
		this.nombre = nombre;
		this.fechaCheckin = fechaCheckin;
		this.fechaCheckout = fechaCheckout;
		this.fechaExtraCheckin = fechaExtraCheckin;
		this.fechaExtraCheckout = fechaExtraCheckout;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public int getIdPaquetesDetalles() {
		return idPaquetesDetalles;
	}

	public String getNombre() {
		return nombre;
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

	@Override
	public String toString() {
		return "Hoteles [idHotel=" + idHotel + ", idPaquetesDetalles=" + idPaquetesDetalles + ", nombre=" + nombre
				+ ", fechaCheckin=" + fechaCheckin + ", fechaCheckout=" + fechaCheckout + ", fechaExtraCheckin="
				+ fechaExtraCheckin + ", fechaExtraCheckout=" + fechaExtraCheckout + "]";
	}

	
	
	
}