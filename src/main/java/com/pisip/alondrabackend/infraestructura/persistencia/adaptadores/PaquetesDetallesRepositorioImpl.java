package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.PaquetesDetalles;
import com.pisip.alondrabackend.dominio.repositorios.IPaquetesDetallesRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaquetesDetallesJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IPaquetesDetallesJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IPaquetesDetallesJpaRepositorio;

public class PaquetesDetallesRepositorioImpl implements IPaquetesDetallesRepositorio {

	private final IPaquetesDetallesJpaRepositorio jpaRepositorio;
	private final IPaquetesDetallesJpaMapper jpaMapper;

	public PaquetesDetallesRepositorioImpl(IPaquetesDetallesJpaRepositorio jpaRepositorio, IPaquetesDetallesJpaMapper jpaMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
	}

	@Override
	public PaquetesDetalles guardar(PaquetesDetalles paquetesDetalles) {
		PaquetesDetallesJpa entity = jpaMapper.toEntity(paquetesDetalles);
		PaquetesDetallesJpa guardado = jpaRepositorio.save(entity);
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<PaquetesDetalles> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<PaquetesDetalles> listarTodo() {
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}

	@Override
	public List<PaquetesDetalles> paquetesDetallesPorRangoFechas(LocalDate inicio, LocalDate fin) {
		return jpaRepositorio.findByRangoFechas(inicio, fin).stream().map(jpaMapper::toDomain).toList();
	}
}
