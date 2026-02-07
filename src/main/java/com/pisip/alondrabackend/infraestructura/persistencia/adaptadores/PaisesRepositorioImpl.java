package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Paises;
import com.pisip.alondrabackend.dominio.repositorios.IPaisesRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaisesJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IPaisesJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IPaisesJpaRepositorio;

public class PaisesRepositorioImpl implements IPaisesRepositorio {

	private final IPaisesJpaRepositorio jpaRepositorio;
	private final IPaisesJpaMapper jpaMapper;

	public PaisesRepositorioImpl(IPaisesJpaRepositorio jpaRepositorio, IPaisesJpaMapper jpaMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
	}

	@Override
	public Paises guardar(Paises paises) {
		PaisesJpa entity = jpaMapper.toEntity(paises);
		PaisesJpa guardado = jpaRepositorio.save(entity);
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Paises> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Paises> listarTodo() {
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}
}
