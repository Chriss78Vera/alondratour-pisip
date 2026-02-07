package com.pisip.alondrabackend.presentacion.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaisConCiudadesResponseDto {
	private int idPais;
	private String pais;
	private List<CiudadResponseDto> ciudades;
}
