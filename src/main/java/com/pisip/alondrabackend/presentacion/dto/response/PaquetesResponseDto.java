package com.pisip.alondrabackend.presentacion.dto.response;

import lombok.Data;

@Data
public class PaquetesResponseDto {
	private int idPaquete;
	private int idPaquetesDetalles;
	private String nombre;
	private String descripcion;
	private int idPais;
	private int idCiudad;
	private String nombrePais;
	private String nombreCiudad;
	private boolean estado;
}
