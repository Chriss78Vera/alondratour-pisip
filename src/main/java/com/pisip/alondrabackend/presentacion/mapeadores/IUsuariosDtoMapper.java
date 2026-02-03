package com.pisip.alondrabackend.presentacion.mapeadores;

import com.pisip.alondrabackend.dominio.entidades.Usuarios;
import com.pisip.alondrabackend.presentacion.dto.request.UsuariosRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.UsuariosResponseDto;

public interface IUsuariosDtoMapper {

	Usuarios toDomain(UsuariosRequestDto dto);

	UsuariosResponseDto toResponse(Usuarios usuarios);
}
