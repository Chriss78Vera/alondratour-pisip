package com.pisip.alondrabackend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDto {

	@NotBlank(message = "El correo electrónico es obligatorio")
	private String correo;

	@NotBlank(message = "La contraseña es obligatoria")
	private String password;
}
