package com.pisip.alondrabackend.presentacion.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaquetesRequestDto {
	private int idPaquete;

	@NotNull
	private Integer idPaquetesDetalles;

	@NotNull
	private String nombre;

	private String descripcion;

	@NotNull
	private Integer idPais;

	@NotNull
	private Integer idCiudad;

	private boolean estado;
}
