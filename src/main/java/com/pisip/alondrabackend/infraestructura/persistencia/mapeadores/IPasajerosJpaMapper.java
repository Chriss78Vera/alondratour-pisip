package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.Pasajeros;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PasajerosJpa;

@Mapper(componentModel = "spring")
public interface IPasajerosJpaMapper {

	@Mapping(source = "reserva.idReserva", target = "idReserva")
	Pasajeros toDomain(PasajerosJpa entity);

	@Mapping(target = "reserva", ignore = true)
	PasajerosJpa toEntity(Pasajeros pasajeros);

}
