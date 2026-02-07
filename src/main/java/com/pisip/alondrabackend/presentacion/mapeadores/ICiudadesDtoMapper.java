package com.pisip.alondrabackend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Ciudades;
import com.pisip.alondrabackend.presentacion.dto.request.CiudadesRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.CiudadesResponseDto;

@Mapper(componentModel = "spring")
public interface ICiudadesDtoMapper {
	Ciudades toDomain(CiudadesRequestDto dto);

	CiudadesResponseDto toResponse(Ciudades ciudades);
}
