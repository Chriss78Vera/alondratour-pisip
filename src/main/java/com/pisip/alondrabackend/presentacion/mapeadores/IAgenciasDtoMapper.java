package com.pisip.alondrabackend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Agencias;
import com.pisip.alondrabackend.presentacion.dto.request.AgenciasRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.AgenciasResponseDto;

@Mapper(componentModel = "spring")
public interface IAgenciasDtoMapper {
	Agencias toDomain(AgenciasRequestDto dto);

	AgenciasResponseDto toResponse(Agencias agencias);
}
