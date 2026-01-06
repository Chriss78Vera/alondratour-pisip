package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Hoteles implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idHotel;

	private Hoteles(int idHotel) {
		this.idHotel = idHotel;
	}

	public int getIdHotel() {
		return idHotel;
	}

	@Override
	public String toString() {
		return "Hoteles [idHotel=" + idHotel + "]";
	}
}