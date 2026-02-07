package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Paquetes;
import com.pisip.alondrabackend.dominio.repositorios.IPaquetesRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaquetesJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IPaquetesJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.ICiudadesJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IPaquetesDetallesJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IPaquetesJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IPaisesJpaRepositorio;

public class PaquetesRepositorioImpl implements IPaquetesRepositorio {

	private final IPaquetesJpaRepositorio jpaRepositorio;
	private final IPaquetesJpaMapper jpaMapper;
	private final IPaquetesDetallesJpaRepositorio paquetesDetallesJpaRepositorio;
	private final IPaisesJpaRepositorio paisesJpaRepositorio;
	private final ICiudadesJpaRepositorio ciudadesJpaRepositorio;

	public PaquetesRepositorioImpl(IPaquetesJpaRepositorio jpaRepositorio, IPaquetesJpaMapper jpaMapper,
			IPaquetesDetallesJpaRepositorio paquetesDetallesJpaRepositorio,
			IPaisesJpaRepositorio paisesJpaRepositorio, ICiudadesJpaRepositorio ciudadesJpaRepositorio) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
		this.paquetesDetallesJpaRepositorio = paquetesDetallesJpaRepositorio;
		this.paisesJpaRepositorio = paisesJpaRepositorio;
		this.ciudadesJpaRepositorio = ciudadesJpaRepositorio;
	}

	@Override
	public Paquetes guardar(Paquetes paquetes) {
		PaquetesJpa entity = jpaMapper.toEntity(paquetes);
		entity.setPaquetesDetalles(paquetesDetallesJpaRepositorio.getReferenceById(paquetes.getIdPaquetesDetalles()));
		entity.setPais(paisesJpaRepositorio.getReferenceById(paquetes.getIdPais()));
		entity.setCiudad(ciudadesJpaRepositorio.getReferenceById(paquetes.getIdCiudad()));
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
	public List<Paquetes> paquetesPorIdPais(int idPais) {
		return jpaRepositorio.findByPais_IdPais(idPais).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Paquetes> paquetesPorIdCiudad(int idCiudad) {
		return jpaRepositorio.findByCiudad_IdCiudad(idCiudad).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Paquetes> paquetesPorIdPaisYIdCiudad(int idPais, int idCiudad) {
		return jpaRepositorio.paquetesPorIdPaisYIdCiudad(idPais, idCiudad).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Paquetes> paquetesPorIdPaquetesDetalles(int idPaquetesDetalles) {
		return jpaRepositorio.paquetesPorIdPaquetesDetalles(idPaquetesDetalles).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<String> paisesDistintos() {
		return jpaRepositorio.findDistinctPaisNombre();
	}

	@Override
	public List<String> ciudadesDistintas() {
		return jpaRepositorio.findDistinctCiudadNombre();
	}
}
