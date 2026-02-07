package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.Ciudades;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.CiudadesJpa;

@Mapper(componentModel = "spring")
public interface ICiudadesJpaMapper {

	@Mapping(source = "pais.idPais", target = "idPais")
	Ciudades toDomain(CiudadesJpa entity);

	@Mapping(target = "pais", ignore = true)
	CiudadesJpa toEntity(Ciudades ciudades);
}
