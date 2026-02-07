package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idRol;
	private final String tipo;

	public Rol(int idRol, String tipo) {
		this.idRol = idRol;
		this.tipo = tipo;
	}

	public int getIdRol() {
		return idRol;
	}

	public String getTipo() {
		return tipo;
	}
}
