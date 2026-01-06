package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Reservas implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idReserva;
	private final int idReservaDetalle;

	private Reservas(
			int idReserva,
			int idReservaDetalle) {

		this.idReserva = idReserva;
		this.idReservaDetalle = idReservaDetalle;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getidReserva() {
		return idReserva;
	}
	public int getidReservaDetalle() {
		return idReservaDetalle;
	}



	@Override
	public String toString() {
		return "Reservas [idReserva=" + idReserva +
				", idReservaDetalle=" + idReservaDetalle + "]";
	}
}
