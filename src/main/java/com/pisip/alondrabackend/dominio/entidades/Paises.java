package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Paises implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idPais;
	private final String nombre;

	public Paises(int idPais, String nombre) {
		this.idPais = idPais;
		this.nombre = nombre;
	}

	public int getIdPais() {
		return idPais;
	}

	public String getNombre() {
		return nombre;
	}
}
