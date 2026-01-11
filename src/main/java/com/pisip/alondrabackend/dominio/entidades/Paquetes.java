package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Paquetes implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idPaquete;
	private final int idPaquetesDetalles;
	private final String pais;
	private final String ciudad;
	
	public Paquetes(int idPaquete, int idPaquetesDetalles, String pais, String ciudad) {
		super();
		this.idPaquete = idPaquete;
		this.idPaquetesDetalles = idPaquetesDetalles;
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

	public String getPais() {
		return pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	@Override
	public String toString() {
		return "Paquetes [idPaquete=" + idPaquete + ", idPaquetesDetalles=" + idPaquetesDetalles + ", pais=" + pais
				+ ", ciudad=" + ciudad + "]";
	}
	
	
}