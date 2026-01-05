package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class ReservaDetalles implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idReservaDetalle;
	private final int idReserva;
	private final int idHotel;
	private final int idServiciosExtras;
	private final int idPaquetes;
	private final int idAgencia;
	private final int idPasajero;
	private final int idVuelos;

	private ReservaDetalles(
			int idReservaDetalle,
			int idReserva,
			int idHotel,
			int idServiciosExtras,
			int idPaquetes,
			int idAgencia,
			int idPasajero,
			int idVuelos) {

		this.idReservaDetalle = idReservaDetalle;
		this.idReserva = idReserva;
		this.idHotel = idHotel;
		this.idServiciosExtras = idServiciosExtras;
		this.idPaquetes = idPaquetes;
		this.idAgencia = idAgencia;
		this.idPasajero = idPasajero;
		this.idVuelos = idVuelos;
	}

	// Falta agregar Reglas de Negocio

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdReservaDetalle() {
		return idReservaDetalle;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public int getIdServiciosExtras() {
		return idServiciosExtras;
	}

	public int getIdPaquetes() {
		return idPaquetes;
	}

	public int getIdAgencia() {
		return idAgencia;
	}

	public int getIdPasajero() {
		return idPasajero;
	}

	public int getIdVuelos() {
		return idVuelos;
	}

	@Override
	public String toString() {
		return "ReservaDetalles [idReservaDetalle=" + idReservaDetalle +
				", idReserva=" + idReserva +
				", idHotel=" + idHotel +
				", idServiciosExtras=" + idServiciosExtras +
				", idPaquetes=" + idPaquetes +
				", idAgencia=" + idAgencia +
				", idPasajero=" + idPasajero +
				", idVuelos=" + idVuelos + "]";
	}
}
