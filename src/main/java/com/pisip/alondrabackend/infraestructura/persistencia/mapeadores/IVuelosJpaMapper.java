package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Vuelos;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.VuelosJpa;

@Mapper(componentModel = "spring")
public interface IVuelosJpaMapper {
	
	Vuelos toDomain(VuelosJpa entity);

	VuelosJpa toEntity(Vuelos vuelos);
}
