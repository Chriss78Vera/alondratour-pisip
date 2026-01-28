package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.ServiciosExtra;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.ServiciosExtraJpa;

@Mapper(componentModel = "spring")
public interface IServiciosExtraJpaMapper {

	@Mapping(source = "reserva.idReserva", target = "idReserva")
	ServiciosExtra toDomain(ServiciosExtraJpa entity);

	@Mapping(target = "reserva", ignore = true)
	ServiciosExtraJpa toEntity(ServiciosExtra serviciosExtra);
}
