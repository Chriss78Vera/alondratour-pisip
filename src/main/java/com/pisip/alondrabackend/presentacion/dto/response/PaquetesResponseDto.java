package com.pisip.alondrabackend.presentacion.dto.response;

import lombok.Data;

@Data
public class PaquetesResponseDto {
	private int idPaquete;
	private int idPaquetesDetalles;
	private String pais;
	private String ciudad;
}
