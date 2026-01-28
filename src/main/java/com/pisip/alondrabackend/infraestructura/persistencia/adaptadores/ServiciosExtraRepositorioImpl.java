package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.ServiciosExtra;
import com.pisip.alondrabackend.dominio.repositorios.IServiciosExtraRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.ServiciosExtraJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IServiciosExtraJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IReservasJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IServiciosExtraJpaRepositorio;

public class ServiciosExtraRepositorioImpl implements IServiciosExtraRepositorio {

	private final IServiciosExtraJpaRepositorio jpaRepositorio;
	private final IServiciosExtraJpaMapper jpaMapper;
	private final IReservasJpaRepositorio reservasJpaRepositorio;

	public ServiciosExtraRepositorioImpl(IServiciosExtraJpaRepositorio jpaRepositorio, IServiciosExtraJpaMapper jpaMapper,
			IReservasJpaRepositorio reservasJpaRepositorio) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
		this.reservasJpaRepositorio = reservasJpaRepositorio;
	}

	@Override
	public ServiciosExtra guardar(ServiciosExtra serviciosExtra) {
		ServiciosExtraJpa entity = jpaMapper.toEntity(serviciosExtra);
		entity.setReserva(reservasJpaRepositorio.getReferenceById(serviciosExtra.getIdReserva()));
		ServiciosExtraJpa guardado = jpaRepositorio.save(entity);
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<ServiciosExtra> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<ServiciosExtra> listarTodo() {
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}

	@Override
	public List<ServiciosExtra> serviciosExtraPorIdReserva(int idReserva) {
		return jpaRepositorio.findByIdReserva(idReserva).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<ServiciosExtra> serviciosExtraPorTipoServicio(String tipoServicio) {
		return jpaRepositorio.findByTipoServicio(tipoServicio).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<ServiciosExtra> serviciosExtraPorRangoFechas(LocalDate inicio, LocalDate fin) {
		return jpaRepositorio.findByRangoFechas(inicio, fin).stream().map(jpaMapper::toDomain).toList();
	}
}
