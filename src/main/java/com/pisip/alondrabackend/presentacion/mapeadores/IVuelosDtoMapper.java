package com.pisip.alondrabackend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Vuelos;
import com.pisip.alondrabackend.presentacion.dto.request.VuelosRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.VuelosResponseDto;

@Mapper(componentModel = "spring")
public interface IVuelosDtoMapper {
	Vuelos toDomain(VuelosRequestDto dto);
	
	VuelosResponseDto toResponse(Vuelos vuelos);
}
