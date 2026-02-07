package com.pisip.alondrabackend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RolRequestDto {
	private int idRol;

	@NotBlank
	private String tipo;
}
