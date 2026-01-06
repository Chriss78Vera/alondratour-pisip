package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class CostoPaquete implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private final int idCostoPaquete;
	private final int idPaquetes;
	private final int idCostos;

	private CostoPaquete(
			int idCostoPaquete,
			int idPaquetes,
			int idCostos) {

		this.idCostoPaquete = idCostoPaquete;
		this.idPaquetes = idPaquetes;
		this.idCostos = idCostos;
	}

	// Getters
	public int getIdCostoPaquete() {
		return idCostoPaquete;
	}

	public int getIdPaquetes() {
		return idPaquetes;
	}

	public int getIdCostos() {
		return idCostos;
	}

	@Override
	public String toString() {
		return "CostoPaquete [idCostoPaquete=" + idCostoPaquete +
				", idPaquetes=" + idPaquetes +
				", idCostos=" + idCostos + "]";
	}
}