package com.pisip.alondrabackend.presentacion.mapeadores;

import org.springframework.stereotype.Component;

import com.pisip.alondrabackend.dominio.entidades.Usuarios;
import com.pisip.alondrabackend.presentacion.dto.request.UsuariosRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.UsuariosResponseDto;

/**
 * Implementación manual del mapper UsuariosRequestDto/Usuarios <-> UsuariosResponseDto.
 * Evita depender del código generado por MapStruct (constructor de 8 parámetros en Usuarios).
 */
@Component
public class UsuariosDtoMapperImpl implements IUsuariosDtoMapper {

	@Override
	public Usuarios toDomain(UsuariosRequestDto dto) {
		if (dto == null) {
			return null;
		}
		// passwordHash se asigna en el controlador al crear; tokenAuth y fechaAuthExp en login; tipoRol se obtiene al cargar desde BD
		return new Usuarios(
				dto.getIdUsuario(),
				dto.getNombre(),
				dto.getCedula(),
				dto.getCorreo(),
				dto.getIdRol(),
				null,
				null,
				dto.getTokenAuth(),
				dto.getFechaAuthExp(),
				dto.isEstado());
	}

	@Override
	public UsuariosResponseDto toResponse(Usuarios usuarios) {
		if (usuarios == null) {
			return null;
		}
		UsuariosResponseDto dto = new UsuariosResponseDto();
		dto.setIdUsuario(usuarios.getIdUsuario());
		dto.setNombre(usuarios.getNombre());
		dto.setCedula(usuarios.getCedula());
		dto.setCorreo(usuarios.getCorreo());
		dto.setIdRol(usuarios.getIdRol());
		dto.setRol(usuarios.getRol());
		dto.setEstado(usuarios.isEstado());
		return dto;
	}
}
