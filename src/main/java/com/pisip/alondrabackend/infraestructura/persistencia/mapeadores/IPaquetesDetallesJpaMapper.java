package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.PaquetesDetalles;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaquetesDetallesJpa;

@Mapper(componentModel = "spring")
public interface IPaquetesDetallesJpaMapper {

	PaquetesDetalles toDomain(PaquetesDetallesJpa entity);

	@Mapping(target = "paquetes", ignore = true)
	PaquetesDetallesJpa toEntity(PaquetesDetalles paquetesDetalles);
}
