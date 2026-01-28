package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Paquetes implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idPaquete;
	private final int idPaquetesDetalles;
	private final String nombre;
	private final String descripcion;
	private final String pais;
	private final String ciudad;

	public Paquetes(int idPaquete, int idPaquetesDetalles, String nombre, String descripcion, String pais, String ciudad) {
		super();
		this.idPaquete = idPaquete;
		this.idPaquetesDetalles = idPaquetesDetalles;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pais = pais;
		this.ciudad = ciudad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getPais() {
		return pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	@Override
	public String toString() {
		return "Paquetes [idPaquete=" + idPaquete + ", idPaquetesDetalles=" + idPaquetesDetalles + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", pais=" + pais + ", ciudad=" + ciudad + "]";
	}
	
	
}