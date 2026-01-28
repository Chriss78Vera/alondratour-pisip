package com.pisip.alondrabackend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Pasajeros;
import com.pisip.alondrabackend.presentacion.dto.request.PasajerosRequestDto;

@Mapper(componentModel = "spring")
public interface IPasajerosDtoMapper {
	
	Pasajeros toDomain(PasajerosRequestDto dto);
	
	PasajerosRequestDto toResponseDto (Pasajeros pasajeros);

}
