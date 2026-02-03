package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.springframework.stereotype.Component;

import com.pisip.alondrabackend.dominio.entidades.Usuarios;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.UsuariosJpa;

@Component
public class UsuariosJpaMapperImpl implements IUsuariosJpaMapper {

	@Override
	public Usuarios toDomain(UsuariosJpa entity) {
		if (entity == null) {
			return null;
		}
		return new Usuarios(
				entity.getIdUsuario(),
				entity.getNombre(),
				entity.getCedula(),
				entity.getCorreo(),
				entity.getRol(),
				entity.getPasswordHash(),
				entity.getTokenAuth(),
				entity.getFechaAuthExp());
	}

	@Override
	public UsuariosJpa toEntity(Usuarios usuarios) {
		if (usuarios == null) {
			return null;
		}
		UsuariosJpa jpa = new UsuariosJpa();
		jpa.setIdUsuario(usuarios.getIdUsuario());
		jpa.setNombre(usuarios.getNombre());
		jpa.setCedula(usuarios.getCedula());
		jpa.setCorreo(usuarios.getCorreo());
		jpa.setRol(usuarios.getRol());
		jpa.setPasswordHash(usuarios.getPasswordHash());
		jpa.setTokenAuth(usuarios.getTokenAuth());
		jpa.setFechaAuthExp(usuarios.getFechaAuthExp());
		return jpa;
	}
}
