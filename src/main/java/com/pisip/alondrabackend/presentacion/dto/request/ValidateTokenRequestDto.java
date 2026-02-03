package com.pisip.alondrabackend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ValidateTokenRequestDto {

	@NotBlank(message = "El token es obligatorio")
	private String tokenAuth;
}
