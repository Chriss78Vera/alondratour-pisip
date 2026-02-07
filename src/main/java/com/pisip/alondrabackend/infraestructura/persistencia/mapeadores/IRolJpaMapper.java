package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.Rol;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.RolJpa;

@Mapper(componentModel = "spring")
public interface IRolJpaMapper {

	Rol toDomain(RolJpa entity);

	@Mapping(target = "usuarios", ignore = true)
	RolJpa toEntity(Rol rol);
}
