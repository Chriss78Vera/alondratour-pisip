package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Reservas;
import com.pisip.alondrabackend.dominio.repositorios.IReservasRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.ReservasJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IReservasJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IReservasJpaRepositorio;

public class ReservasRepositorioImpl implements IReservasRepositorio{
	
	
	private final IReservasJpaRepositorio jpaRepositorio;
	private final IReservasJpaMapper jpaMapper;

	public ReservasRepositorioImpl(IReservasJpaRepositorio jpaRepositorio, IReservasJpaMapper jpaMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
		
		
		
	}

	@Override
	public Reservas guardar(Reservas reservas) {
		ReservasJpa entity = jpaMapper.toEntity(reservas);
		ReservasJpa guardado = jpaRepositorio.save(entity);
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Reservas> bucarPorId(int id) {
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Reservas> listarTodos() {
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
		
	}

}
