package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.Agencias;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.AgenciasJpa;

@Mapper(componentModel = "spring")
public interface IAgenciasJpaMapper {

	Agencias toDomain(AgenciasJpa entity);

	@Mapping(target = "reservas", ignore = true)
	AgenciasJpa toEntity(Agencias agencias);
}
