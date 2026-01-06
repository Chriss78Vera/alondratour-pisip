package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Pasajeros implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idPasajero;

	private Pasajeros(
			int idPasajero) {

		this.idPasajero = idPasajero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getidPasajero() {
		return idPasajero;
	}



	@Override
	public String toString() {
		return "Pasajeros [idPasajero=" + idPasajero + "]";
	}
}
