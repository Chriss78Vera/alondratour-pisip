package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Rol;
import com.pisip.alondrabackend.dominio.repositorios.IRolRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.RolJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IRolJpaRepositorio;

public class RolRepositorioImpl implements IRolRepositorio {

	private final IRolJpaRepositorio jpaRepositorio;
	private final IRolJpaMapper jpaMapper;

	public RolRepositorioImpl(IRolJpaRepositorio jpaRepositorio, IRolJpaMapper jpaMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
	}

	@Override
	public Rol guardar(Rol rol) {
		RolJpa entity = jpaMapper.toEntity(rol);
		RolJpa guardado = jpaRepositorio.save(entity);
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Rol> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Rol> listarTodo() {
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}

	@Override
	public Optional<Rol> buscarPorTipo(String tipo) {
		return jpaRepositorio.findByTipo(tipo).map(jpaMapper::toDomain);
	}
}
