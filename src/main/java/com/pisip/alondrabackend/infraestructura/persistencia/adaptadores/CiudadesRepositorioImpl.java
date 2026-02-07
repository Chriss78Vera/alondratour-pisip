package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Ciudades;
import com.pisip.alondrabackend.dominio.repositorios.ICiudadesRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.CiudadesJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.ICiudadesJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.ICiudadesJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IPaisesJpaRepositorio;

public class CiudadesRepositorioImpl implements ICiudadesRepositorio {

	private final ICiudadesJpaRepositorio jpaRepositorio;
	private final ICiudadesJpaMapper jpaMapper;
	private final IPaisesJpaRepositorio paisesJpaRepositorio;

	public CiudadesRepositorioImpl(ICiudadesJpaRepositorio jpaRepositorio, ICiudadesJpaMapper jpaMapper,
			IPaisesJpaRepositorio paisesJpaRepositorio) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
		this.paisesJpaRepositorio = paisesJpaRepositorio;
	}

	@Override
	public Ciudades guardar(Ciudades ciudades) {
		CiudadesJpa entity = jpaMapper.toEntity(ciudades);
		entity.setPais(paisesJpaRepositorio.getReferenceById(ciudades.getIdPais()));
		CiudadesJpa guardado = jpaRepositorio.save(entity);
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Ciudades> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Ciudades> listarTodo() {
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}

	@Override
	public List<Ciudades> buscarPorIdPais(int idPais) {
		return jpaRepositorio.findByPais_IdPais(idPais).stream().map(jpaMapper::toDomain).toList();
	}
}
