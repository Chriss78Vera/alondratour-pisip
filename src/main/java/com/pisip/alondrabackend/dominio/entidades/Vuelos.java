package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class Vuelos implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private final int idVuelo;
	private final String aerolinea;
	private final String origen;
	private final String destino;
	private final LocalDate fechaSalida;
	private final LocalDate fechaLlegada;
	private final LocalDate fechaExtraSalida;
	private final LocalDate fechaExtraLlegada;
	
	public Vuelos(int idVuelo, String aerolinea, String origen, String destino, LocalDate fechaSalida,
			LocalDate fechaLlegada, LocalDate fechaExtraSalida, LocalDate fechaExtraLlegada) {
		super();
		this.idVuelo = idVuelo;
		this.aerolinea = aerolinea;
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.fechaExtraSalida = fechaExtraSalida;
		this.fechaExtraLlegada = fechaExtraLlegada;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public LocalDate getFechaLlegada() {
		return fechaLlegada;
	}

	public LocalDate getFechaExtraSalida() {
		return fechaExtraSalida;
	}

	public LocalDate getFechaExtraLlegada() {
		return fechaExtraLlegada;
	}

	@Override
	public String toString() {
		return "Vuelos [idVuelo=" + idVuelo + ", aerolinea=" + aerolinea + ", origen=" + origen + ", destino=" + destino
				+ ", fechaSalida=" + fechaSalida + ", fechaLlegada=" + fechaLlegada + ", fechaExtraSalida="
				+ fechaExtraSalida + ", fechaExtraLlegada=" + fechaExtraLlegada + "]";
	}
	
	
}
