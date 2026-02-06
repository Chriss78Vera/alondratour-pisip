package com.pisip.alondrabackend.presentacion.dto.response;

import lombok.Data;

@Data
public class PaquetesResponseDto {
	private int idPaquete;
	private int idPaquetesDetalles;
	private String nombre;
	private String descripcion;
	private String pais;
	private String ciudad;
	private boolean estado;
}
