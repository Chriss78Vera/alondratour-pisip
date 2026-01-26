package com.pisip.alondrabackend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Reservas;
import com.pisip.alondrabackend.presentacion.dto.request.ReservasRequestDto;


@Mapper(componentModel = "spring")
public interface IReservasDtoMapper {
	
	Reservas toDomain(ReservasRequestDto dto); // de DTO a entidad de dominio
	
	ReservasRequestDto toResponseDto (Reservas reservas);

}
