package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class Reservas implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idReserva;
	private final int idUsuario;
	private final int idVuelo;
	private final int idPaquete;
	private final int idAgencia;
	private final LocalDate fechaReserva;
	private final float costoTotal;
	private final boolean estado;

	public Reservas(int idReserva, int idUsuario, int idVuelo, int idPaquete, int idAgencia,
			LocalDate fechaReserva, float costoTotal, boolean estado) {
		super();
		this.idReserva = idReserva;
		this.idUsuario = idUsuario;
		this.idVuelo = idVuelo;
		this.idPaquete = idPaquete;
		this.idAgencia = idAgencia;
		this.fechaReserva = fechaReserva;
		this.costoTotal = costoTotal;
		this.estado = estado;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public int getIdVuelo() {
		return idVuelo;
	}


	public int getIdPaquete() {
		return idPaquete;
	}


	public int getIdAgencia() {
		return idAgencia;
	}


	public LocalDate getFechaReserva() {
		return fechaReserva;
	}


	public float getCostoTotal() {
		return costoTotal;
	}


	public boolean isEstado() {
		return estado;
	}


	@Override
	public String toString() {
		return "Reservas [idReserva=" + idReserva + ", idUsuario=" + idUsuario + ", idVuelo=" + idVuelo
				+ ", idPaquete=" + idPaquete + ", idAgencia=" + idAgencia + ", fechaReserva=" + fechaReserva
				+ ", costoTotal=" + costoTotal + ", estado=" + estado + "]";
	}

	
	
}
