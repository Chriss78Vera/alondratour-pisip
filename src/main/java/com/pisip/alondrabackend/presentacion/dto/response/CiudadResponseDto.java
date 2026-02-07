package com.pisip.alondrabackend.presentacion.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CiudadResponseDto {
	private int idCiudad;
	private String nombre;
}
