package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.Paquetes;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaquetesJpa;

@Mapper(componentModel = "spring")
public interface IPaquetesJpaMapper {

	@Mapping(source = "idPaquetes", target = "idPaquete")
	@Mapping(source = "paquetesDetalles.idPaquetesDetalles", target = "idPaquetesDetalles")
	Paquetes toDomain(PaquetesJpa entity);

	@Mapping(source = "idPaquete", target = "idPaquetes")
	@Mapping(target = "paquetesDetalles", ignore = true)
	@Mapping(target = "reservas", ignore = true)
	PaquetesJpa toEntity(Paquetes paquetes);
}
