package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Agencias implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idAgencia;

	private Agencias(
			int idAgencia) {

		this.idAgencia = idAgencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getidAgencia() {
		return idAgencia;
	}



	@Override
	public String toString() {
		return "Agencias [idAgencia=" + idAgencia + "]";
	}
}
