package com.pisip.alondrabackend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Hoteles;
import com.pisip.alondrabackend.presentacion.dto.request.HotelesRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.HotelesResponseDto;

@Mapper(componentModel = "spring")
public interface IHotelesDtoMapper {
	Hoteles toDomain(HotelesRequestDto dto);
	
	HotelesResponseDto toResponse(Hoteles hoteles);
}
