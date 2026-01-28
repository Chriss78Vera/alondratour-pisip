package com.pisip.alondrabackend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.PaquetesDetalles;
import com.pisip.alondrabackend.presentacion.dto.request.PaquetesDetallesRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.PaquetesDetallesResponseDto;

@Mapper(componentModel = "spring")
public interface IPaquetesDetallesDtoMapper {
	PaquetesDetalles toDomain(PaquetesDetallesRequestDto dto);

	PaquetesDetallesResponseDto toResponse(PaquetesDetalles paquetesDetalles);
}
