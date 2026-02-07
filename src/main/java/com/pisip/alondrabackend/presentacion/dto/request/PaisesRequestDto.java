package com.pisip.alondrabackend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PaisesRequestDto {
	private int idPais;

	@NotBlank
	private String nombre;
}
