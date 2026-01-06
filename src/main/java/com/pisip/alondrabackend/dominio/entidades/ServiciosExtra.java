package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class ServiciosExtra implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idServicioExtra;

	private ServiciosExtra(
			int idServicioExtra) {

		this.idServicioExtra = idServicioExtra;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getidServicioExtra() {
		return idServicioExtra;
	}



	@Override
	public String toString() {
		return "ServiciosExtra [idServicioExtra=" + idServicioExtra + "]";
	}
}
