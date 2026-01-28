package com.pisip.alondrabackend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuariosRequestDto {
	@NotBlank
	private int idUsuario;

	@NotBlank
	private String nombre;

	@NotBlank
	private String cedula;

	@NotBlank
	private String correo;

	@NotBlank
	private String rol;
}
