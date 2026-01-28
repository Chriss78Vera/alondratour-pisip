package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Hoteles implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idHotel;
	private final int idPaquetesDetalles;
	private final String nombre;

	public Hoteles(int idHotel, int idPaquetesDetalles, String nombre) {
		super();
		this.idHotel = idHotel;
		this.idPaquetesDetalles = idPaquetesDetalles;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Hoteles [idHotel=" + idHotel + ", idPaquetesDetalles=" + idPaquetesDetalles + ", nombre=" + nombre + "]";
	}
}
