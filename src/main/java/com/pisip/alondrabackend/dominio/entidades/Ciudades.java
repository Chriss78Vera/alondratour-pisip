package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Ciudades implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idCiudad;
	private final String nombre;
	private final int idPais;

	public Ciudades(int idCiudad, String nombre, int idPais) {
		this.idCiudad = idCiudad;
		this.nombre = nombre;
		this.idPais = idPais;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getIdPais() {
		return idPais;
	}
}
