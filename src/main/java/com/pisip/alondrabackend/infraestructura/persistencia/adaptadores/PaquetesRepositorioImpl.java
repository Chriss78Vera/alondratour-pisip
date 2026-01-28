package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Paquetes;
import com.pisip.alondrabackend.dominio.repositorios.IPaquetesRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaquetesJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IPaquetesJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IPaquetesDetallesJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IPaquetesJpaRepositorio;

public class PaquetesRepositorioImpl implements IPaquetesRepositorio {

	private final IPaquetesJpaRepositorio jpaRepositorio;
	private final IPaquetesJpaMapper jpaMapper;
	private final IPaquetesDetallesJpaRepositorio paquetesDetallesJpaRepositorio;

	public PaquetesRepositorioImpl(IPaquetesJpaRepositorio jpaRepositorio, IPaquetesJpaMapper jpaMapper,
			IPaquetesDetallesJpaRepositorio paquetesDetallesJpaRepositorio) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
		this.paquetesDetallesJpaRepositorio = paquetesDetallesJpaRepositorio;
	}

	@Override
	public Paquetes guardar(Paquetes paquetes) {
		PaquetesJpa entity = jpaMapper.toEntity(paquetes);
		entity.setPaquetesDetalles(paquetesDetallesJpaRepositorio.getReferenceById(paquetes.getIdPaquetesDetalles()));
		PaquetesJpa guardado = jpaRepositorio.save(entity);
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Paquetes> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Paquetes> listarTodo() {
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}

	@Override
	public List<Paquetes> paquetesPorPais(String pais) {
		return jpaRepositorio.paquetesPorPais(pais).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Paquetes> paquetesPorCiudad(String ciudad) {
		return jpaRepositorio.paquetesPorCiudad(ciudad).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Paquetes> paquetesPorPaisYCiudad(String pais, String ciudad) {
		return jpaRepositorio.paquetesPorPaisYCiudad(pais, ciudad).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Paquetes> paquetesPorIdPaquetesDetalles(int idPaquetesDetalles) {
		return jpaRepositorio.paquetesPorIdPaquetesDetalles(idPaquetesDetalles).stream().map(jpaMapper::toDomain).toList();
	}
}
