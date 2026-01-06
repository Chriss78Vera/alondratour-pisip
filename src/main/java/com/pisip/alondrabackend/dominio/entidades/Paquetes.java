package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Paquetes implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idPaquetes;

	private Paquetes(int idPaquetes) {
		this.idPaquetes = idPaquetes;
	}

	public int getIdPaquetes() {
		return idPaquetes;
	}

	@Override
	public String toString() {
		return "Paquetes [idPaquetes=" + idPaquetes + "]";
	}
}