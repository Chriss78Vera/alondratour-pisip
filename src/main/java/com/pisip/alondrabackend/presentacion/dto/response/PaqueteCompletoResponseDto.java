package com.pisip.alondrabackend.presentacion.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaqueteCompletoResponseDto {
	private int idPaquete;
	private int idPaquetesDetalles;
	private String nombre;
	private String descripcion;
	private String pais;
	private String ciudad;
	private boolean estado;
	private PaquetesDetallesResponseDto paquetesDetalles;
	private List<HotelesResponseDto> hoteles;
}
