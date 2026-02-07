package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Paquetes implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idPaquete;
	private final int idPaquetesDetalles;
	private final String nombre;
	private final String descripcion;
	private final int idPais;
	private final int idCiudad;
	private final String nombrePais;
	private final String nombreCiudad;
	private final boolean estado;

	public Paquetes(int idPaquete, int idPaquetesDetalles, String nombre, String descripcion,
			int idPais, int idCiudad, String nombrePais, String nombreCiudad, boolean estado) {
		this.idPaquete = idPaquete;
		this.idPaquetesDetalles = idPaquetesDetalles;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.idPais = idPais;
		this.idCiudad = idCiudad;
		this.nombrePais = nombrePais;
		this.nombreCiudad = nombreCiudad;
		this.estado = estado;
	}

	public int getIdPaquete() {
		return idPaquete;
	}

	public int getIdPaquetesDetalles() {
		return idPaquetesDetalles;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getIdPais() {
		return idPais;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public boolean isEstado() {
		return estado;
	}
}
