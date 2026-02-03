package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import com.pisip.alondrabackend.dominio.entidades.Usuarios;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.UsuariosJpa;

public interface IUsuariosJpaMapper {

	Usuarios toDomain(UsuariosJpa entity);

	UsuariosJpa toEntity(Usuarios usuarios);
}
