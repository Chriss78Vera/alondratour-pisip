package com.pisip.alondrabackend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDto {

	@NotBlank(message = "La cédula (usuario) es obligatoria")
	private String cedula;

	@NotBlank(message = "La contraseña es obligatoria")
	private String password;
}
