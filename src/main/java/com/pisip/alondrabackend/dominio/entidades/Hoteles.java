package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class Hoteles implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idHotel;
	private final String nombre;
	private final String ciudad;
	private final String pais;
	private final LocalDate fechaCheckin;
	private final LocalDate fechaCheckout;
	private final LocalDate fechaExtraCheckin;
	private final LocalDate fechaExtraCheckout;
	
	public Hoteles(int idHotel, String nombre, String ciudad, String pais, LocalDate fechaCheckin,
			LocalDate fechaCheckout, LocalDate fechaExtraCheckin, LocalDate fechaExtraCheckout) {
		super();
		this.idHotel = idHotel;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
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

	public String getNombre() {
		return nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getPais() {
		return pais;
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
		return "Hoteles [idHotel=" + idHotel + ", nombre=" + nombre + ", ciudad=" + ciudad + ", pais=" + pais
				+ ", fechaCheckin=" + fechaCheckin + ", fechaCheckout=" + fechaCheckout + ", fechaExtraCheckin="
				+ fechaExtraCheckin + ", fechaExtraCheckout=" + fechaExtraCheckout + "]";
	}

	
	
	
}