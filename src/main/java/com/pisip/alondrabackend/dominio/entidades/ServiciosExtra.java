package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class ServiciosExtra implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idServiciosExtra;
	private final int idReserva;
	private final float costo;
	private final String tipoServicio;
	private final LocalDate fechaInicio;
	private final LocalDate fechaFin;
	
	public ServiciosExtra(int idServiciosExtra, int idReserva, float costo, String tipoServicio, LocalDate fechaInicio,
			LocalDate fechaFin) {
		super();
		this.idServiciosExtra = idServiciosExtra;
		this.idReserva = idReserva;
		this.costo = costo;
		this.tipoServicio = tipoServicio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdServiciosExtra() {
		return idServiciosExtra;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public float getCosto() {
		return costo;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	@Override
	public String toString() {
		return "ServiciosExtra [idServiciosExtra=" + idServiciosExtra + ", idReserva=" + idReserva + ", costo=" + costo
				+ ", tipoServicio=" + tipoServicio + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	
}
