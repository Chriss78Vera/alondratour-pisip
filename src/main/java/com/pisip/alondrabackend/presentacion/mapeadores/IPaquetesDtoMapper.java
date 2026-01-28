package com.pisip.alondrabackend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Paquetes;
import com.pisip.alondrabackend.presentacion.dto.request.PaquetesRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.PaquetesResponseDto;

@Mapper(componentModel = "spring")
public interface IPaquetesDtoMapper {
	Paquetes toDomain(PaquetesRequestDto dto);

	PaquetesResponseDto toResponse(Paquetes paquetes);
}
