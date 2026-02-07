package com.pisip.alondrabackend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CiudadesRequestDto {
	private int idCiudad;

	@NotBlank
	private String nombre;

	@NotNull
	private Integer idPais;
}
