package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Agencias;
import com.pisip.alondrabackend.dominio.repositorios.IAgenciasRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.AgenciasJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IAgenciasJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IAgenciasJpaRepositorio;

public class AgenciasRepositorioImpl implements IAgenciasRepositorio {

	private final IAgenciasJpaRepositorio jpaRepositorio;
	private final IAgenciasJpaMapper jpaMapper;

	public AgenciasRepositorioImpl(IAgenciasJpaRepositorio jpaRepositorio, IAgenciasJpaMapper jpaMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
	}

	@Override
	public Agencias guardar(Agencias agencias) {
		AgenciasJpa entity = jpaMapper.toEntity(agencias);
		AgenciasJpa guardado = jpaRepositorio.save(entity);
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Agencias> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Agencias> listarTodo() {
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}

	@Override
	public List<Agencias> agenciasPorNombre(String nombre) {
		return jpaRepositorio.findByNombre(nombre).stream().map(jpaMapper::toDomain).toList();
	}
}
