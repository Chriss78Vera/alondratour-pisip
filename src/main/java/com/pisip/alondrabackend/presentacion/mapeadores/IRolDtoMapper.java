package com.pisip.alondrabackend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Rol;
import com.pisip.alondrabackend.presentacion.dto.request.RolRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.RolResponseDto;

@Mapper(componentModel = "spring")
public interface IRolDtoMapper {
	Rol toDomain(RolRequestDto dto);

	RolResponseDto toResponse(Rol rol);
}
