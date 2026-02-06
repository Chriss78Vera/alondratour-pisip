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

	/** Obligatoria al crear; opcional al actualizar (si viene vacía se mantiene la actual). */
	private String password;
	
	private String tokenAuth;
	private LocalDateTime fechaAuthExp;
	/** Por defecto true; se puede modificar al actualizar usuario. */
	private boolean estado = true;
}
