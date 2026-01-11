package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Vuelos;
import com.pisip.alondrabackend.dominio.repositorios.IVuelosRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.VuelosJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IVuelosJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IVuelosJpaRepositorio;

public class VuelosRepositorioImpl implements IVuelosRepositorio {
	
	private final IVuelosJpaRepositorio jpaRepositorio;
	private final IVuelosJpaMapper jpaMapper;
	
	

	public VuelosRepositorioImpl(IVuelosJpaRepositorio jpaRepositorio, IVuelosJpaMapper jpaMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
	}

	@Override
	public Vuelos guardar(Vuelos vuelos) {
		VuelosJpa entity = jpaMapper.toEntity(vuelos);
		VuelosJpa guardado = jpaRepositorio.save(entity);
		// TODO Auto-generated method stub
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Vuelos> buscarPorId(int id) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Vuelos> listarTodo() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(id);
	}

	
}
