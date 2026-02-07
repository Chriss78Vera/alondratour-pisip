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
		int idRol = entity.getRol() != null ? entity.getRol().getIdRol() : 0;
		String tipoRol = entity.getRol() != null ? entity.getRol().getTipo() : null;
		return new Usuarios(
				entity.getIdUsuario(),
				entity.getNombre(),
				entity.getCedula(),
				entity.getCorreo(),
				idRol,
				tipoRol,
				entity.getPasswordHash(),
				entity.getTokenAuth(),
				entity.getFechaAuthExp(),
				entity.isEstado());
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
		// rol se asigna en el adaptador con getReferenceById(usuarios.getIdRol())
		jpa.setPasswordHash(usuarios.getPasswordHash());
		jpa.setTokenAuth(usuarios.getTokenAuth());
		jpa.setFechaAuthExp(usuarios.getFechaAuthExp());
		jpa.setEstado(usuarios.isEstado());
		return jpa;
	}
}
