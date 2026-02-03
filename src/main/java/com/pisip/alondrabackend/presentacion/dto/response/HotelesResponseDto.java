package com.pisip.alondrabackend.presentacion.dto.response;

import lombok.Data;

@Data
public class HotelesResponseDto {
	private int idHotel;
	private int idPaquetesDetalles;
	private String nombre;
	private float precio;
}
