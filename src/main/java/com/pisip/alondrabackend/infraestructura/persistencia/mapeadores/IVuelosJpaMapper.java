package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.Vuelos;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.VuelosJpa;

@Mapper(componentModel = "spring")
public interface IVuelosJpaMapper {

	Vuelos toDomain(VuelosJpa entity);

	@Mapping(target = "reservas", ignore = true)
	VuelosJpa toEntity(Vuelos vuelos);
}
