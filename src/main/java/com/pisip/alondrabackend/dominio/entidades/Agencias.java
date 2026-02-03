package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Agencias implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idAgencia;
	private final String nombre;
	private final String telefono;
	private final String email;

	public Agencias(int idAgencia, String nombre, String telefono, String email) {
		this.idAgencia = idAgencia;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public int getIdAgencia() {
		return idAgencia;
	}



	public String getNombre() {
		return nombre;
	}



	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Agencias [idAgencia=" + idAgencia + "]";
	}
}
