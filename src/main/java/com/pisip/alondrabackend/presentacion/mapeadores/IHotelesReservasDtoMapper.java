package com.pisip.alondrabackend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.HotelesReservas;
import com.pisip.alondrabackend.presentacion.dto.request.HotelesReservasRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.HotelesReservasResponseDto;

@Mapper(componentModel = "spring")
public interface IHotelesReservasDtoMapper {
	HotelesReservas toDomain(HotelesReservasRequestDto dto);

	HotelesReservasResponseDto toResponse(HotelesReservas hotelesReservas);
}
