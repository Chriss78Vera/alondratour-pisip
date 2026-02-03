package com.pisip.alondrabackend.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuariosRequestDto {
	private int idUsuario;

	@NotBlank
	private String nombre;

	@NotBlank
	private String cedula;

	@NotBlank
	private String correo;

	@NotBlank
	private String rol;

	@NotBlank(message = "La contraseña es obligatoria para crear/actualizar usuario")
	private String password;
	
	private  String tokenAuth;
	
	private  LocalDateTime fechaAuthExp;
}
