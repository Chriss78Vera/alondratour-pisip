package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.Usuarios;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.UsuariosJpa;

@Mapper(componentModel = "spring")
public interface IUsuariosJpaMapper {

	Usuarios toDomain(UsuariosJpa entity);

	@Mapping(target = "reservas", ignore = true)
	UsuariosJpa toEntity(Usuarios usuarios);
}
