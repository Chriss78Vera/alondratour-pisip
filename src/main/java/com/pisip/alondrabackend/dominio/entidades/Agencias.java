package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Agencias implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idAgencia;
	private final String nombre;
	private final String telefono;
	
	
	public Agencias(int idAgencia, String nombre, String telefono) {
		this.idAgencia = idAgencia;
		this.nombre = nombre;
		this.telefono = telefono;
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



	@Override
	public String toString() {
		return "Agencias [idAgencia=" + idAgencia + "]";
	}
}
