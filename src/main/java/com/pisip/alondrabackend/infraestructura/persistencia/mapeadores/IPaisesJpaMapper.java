package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.Paises;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaisesJpa;

@Mapper(componentModel = "spring")
public interface IPaisesJpaMapper {

	Paises toDomain(PaisesJpa entity);

	@Mapping(target = "ciudades", ignore = true)
	PaisesJpa toEntity(Paises paises);
}
