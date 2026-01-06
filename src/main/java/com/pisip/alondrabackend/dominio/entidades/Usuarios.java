package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idUsuario;

	private Usuarios(
			int idUsuario) {

		this.idUsuario = idUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getidUsuario() {
		return idUsuario;
	}



	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + "]";
	}
}
