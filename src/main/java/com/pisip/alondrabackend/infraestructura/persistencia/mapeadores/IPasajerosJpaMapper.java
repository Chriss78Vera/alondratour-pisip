package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Pasajeros;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PasajerosJpa;

@Mapper(componentModel = "spring")
public interface IPasajerosJpaMapper {
	
	Pasajeros toDomain(PasajerosJpa entity);

	PasajerosJpa toEntity(Pasajeros pasajeros);

}
