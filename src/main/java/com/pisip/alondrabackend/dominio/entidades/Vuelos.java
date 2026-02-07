package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class Vuelos implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idVuelo;
	private final String aerolinea;
	private final int idPaisDestino;
	private final int idCiudadDestino;
	private final String nombrePaisDestino;
	private final String nombreCiudadDestino;
	private final LocalDate fechaSalida;
	private final LocalDate fechaLlegada;
	private final LocalDate fechaExtraSalida;
	private final LocalDate fechaExtraLlegada;

	public Vuelos(int idVuelo, String aerolinea, int idPaisDestino, int idCiudadDestino,
			String nombrePaisDestino, String nombreCiudadDestino,
			LocalDate fechaSalida, LocalDate fechaLlegada,
			LocalDate fechaExtraSalida, LocalDate fechaExtraLlegada) {
		this.idVuelo = idVuelo;
		this.aerolinea = aerolinea;
		this.idPaisDestino = idPaisDestino;
		this.idCiudadDestino = idCiudadDestino;
		this.nombrePaisDestino = nombrePaisDestino;
		this.nombreCiudadDestino = nombreCiudadDestino;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.fechaExtraSalida = fechaExtraSalida;
		this.fechaExtraLlegada = fechaExtraLlegada;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public int getIdPaisDestino() {
		return idPaisDestino;
	}

	public int getIdCiudadDestino() {
		return idCiudadDestino;
	}

	public String getNombrePaisDestino() {
		return nombrePaisDestino;
	}

	public String getNombreCiudadDestino() {
		return nombreCiudadDestino;
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
}
