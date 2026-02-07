package com.pisip.alondrabackend.presentacion.dto.response;

import lombok.Data;

@Data
public class UsuariosResponseDto {
	private int idUsuario;
	private String nombre;
	private String cedula;
	private String correo;
	private int idRol;
	private String rol;
	private boolean estado;
}
