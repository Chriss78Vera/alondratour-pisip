package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class PaquetesDetalles implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private final int idPaquetesDetalles;
	private final LocalDate fechaInicio;
	private final LocalDate fechaFin;
	private final float precioNeto;

	public PaquetesDetalles(int idPaquetesDetalles, LocalDate fechaInicio, LocalDate fechaFin, float precioNeto) {
		super();
		this.idPaquetesDetalles = idPaquetesDetalles;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precioNeto = precioNeto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdPaquetesDetalles() {
		return idPaquetesDetalles;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public float getPrecioNeto() {
		return precioNeto;
	}

	@Override
	public String toString() {
		return "PaquetesDetalles [idPaquetesDetalles=" + idPaquetesDetalles + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", precioNeto=" + precioNeto + "]";
	}
	
	

}
