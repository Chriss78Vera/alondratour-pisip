package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Pasajeros;
import com.pisip.alondrabackend.dominio.repositorios.IPasajerosRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PasajerosJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IPasajerosJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IPasajerosJpaRepositorio;

public class PasajerosRepositorioImpl implements IPasajerosRepositorio{
	
	private final IPasajerosJpaRepositorio jpaRepositorio;
	private final IPasajerosJpaMapper jpaMapper;
	
	

	public PasajerosRepositorioImpl(IPasajerosJpaRepositorio jpaRepositorio, IPasajerosJpaMapper jpaMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
	}

	@Override
	public Pasajeros guardar(Pasajeros pasajeros) {
		PasajerosJpa entity = jpaMapper.toEntity(pasajeros);
		PasajerosJpa guardado = jpaRepositorio.save(entity);
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Pasajeros> bucarPorId(int id) {
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Pasajeros> listarTodos() {
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {	
		jpaRepositorio.deleteById(id);
		
	}

}
