package com.pisip.alondrabackend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Paises;
import com.pisip.alondrabackend.presentacion.dto.request.PaisesRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.PaisesResponseDto;

@Mapper(componentModel = "spring")
public interface IPaisesDtoMapper {
	Paises toDomain(PaisesRequestDto dto);

	PaisesResponseDto toResponse(Paises paises);
}
