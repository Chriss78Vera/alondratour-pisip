package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Hoteles;
import com.pisip.alondrabackend.dominio.repositorios.IHotelesRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.HotelesJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IHotelesJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IHotelesJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IPaquetesDetallesJpaRepositorio;

public class HotelesRepositorioImpl implements IHotelesRepositorio {

	private final IHotelesJpaRepositorio jpaRepositorio;
	private final IHotelesJpaMapper jpaMapper;
	private final IPaquetesDetallesJpaRepositorio paquetesDetallesJpaRepositorio;

	public HotelesRepositorioImpl(IHotelesJpaRepositorio jpaRepositorio, IHotelesJpaMapper jpaMapper,
			IPaquetesDetallesJpaRepositorio paquetesDetallesJpaRepositorio) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
		this.paquetesDetallesJpaRepositorio = paquetesDetallesJpaRepositorio;
	}

	@Override
	public Hoteles guardar(Hoteles hoteles) {
		HotelesJpa entity = jpaMapper.toEntity(hoteles);
		entity.setPaquetesDetalles(paquetesDetallesJpaRepositorio.getReferenceById(hoteles.getIdPaquetesDetalles()));
		HotelesJpa guardado = jpaRepositorio.save(entity);
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Hoteles> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Hoteles> listarTodo() {
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}

	@Override
	public List<Hoteles> hotelesPorNombre(String nombre) {
		return jpaRepositorio.hotelesPorNombre(nombre).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Hoteles> hotelesPorIdPaquetesDetalles(int idPaquetesDetalles) {
		return jpaRepositorio.findByPaquetesDetallesIdPaquetesDetalles(idPaquetesDetalles).stream().map(jpaMapper::toDomain).toList();
	}
}
