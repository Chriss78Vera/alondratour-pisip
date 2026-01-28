package com.pisip.alondrabackend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.ServiciosExtra;
import com.pisip.alondrabackend.presentacion.dto.request.ServiciosExtraRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.ServiciosExtraResponseDto;

@Mapper(componentModel = "spring")
public interface IServiciosExtraDtoMapper {
	ServiciosExtra toDomain(ServiciosExtraRequestDto dto);

	ServiciosExtraResponseDto toResponse(ServiciosExtra serviciosExtra);
}
