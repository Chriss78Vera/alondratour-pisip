package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.HotelesReservas;
import com.pisip.alondrabackend.dominio.repositorios.IHotelesReservasRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.HotelesReservasJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IHotelesReservasJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IHotelesJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IHotelesReservasJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IReservasJpaRepositorio;

public class HotelesReservasRepositorioImpl implements IHotelesReservasRepositorio {

	private final IHotelesReservasJpaRepositorio jpaRepositorio;
	private final IHotelesReservasJpaMapper jpaMapper;
	private final IReservasJpaRepositorio reservasJpaRepositorio;
	private final IHotelesJpaRepositorio hotelesJpaRepositorio;

	public HotelesReservasRepositorioImpl(IHotelesReservasJpaRepositorio jpaRepositorio,
			IHotelesReservasJpaMapper jpaMapper, IReservasJpaRepositorio reservasJpaRepositorio,
			IHotelesJpaRepositorio hotelesJpaRepositorio) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
		this.reservasJpaRepositorio = reservasJpaRepositorio;
		this.hotelesJpaRepositorio = hotelesJpaRepositorio;
	}

	@Override
	public HotelesReservas guardar(HotelesReservas hotelesReservas) {
		HotelesReservasJpa entity = jpaMapper.toEntity(hotelesReservas);
		entity.setReserva(reservasJpaRepositorio.getReferenceById(hotelesReservas.getIdReserva()));
		entity.setHotel(hotelesJpaRepositorio.getReferenceById(hotelesReservas.getIdHotel()));
		HotelesReservasJpa guardado = jpaRepositorio.save(entity);
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<HotelesReservas> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<HotelesReservas> listarTodo() {
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}

	@Override
	public List<HotelesReservas> hotelesReservasPorIdReserva(int idReserva) {
		return jpaRepositorio.findByIdReserva(idReserva).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<HotelesReservas> hotelesReservasPorIdHotel(int idHotel) {
		return jpaRepositorio.findByIdHotel(idHotel).stream().map(jpaMapper::toDomain).toList();
	}
}
