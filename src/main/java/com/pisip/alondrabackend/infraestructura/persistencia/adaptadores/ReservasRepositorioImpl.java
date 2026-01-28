package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Reservas;
import com.pisip.alondrabackend.dominio.repositorios.IReservasRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.ReservasJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IReservasJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IAgenciasJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IPaquetesJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IReservasJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IUsuariosJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IVuelosJpaRepositorio;

public class ReservasRepositorioImpl implements IReservasRepositorio{

	private final IReservasJpaRepositorio jpaRepositorio;
	private final IReservasJpaMapper jpaMapper;
	private final IUsuariosJpaRepositorio usuariosJpaRepositorio;
	private final IVuelosJpaRepositorio vuelosJpaRepositorio;
	private final IPaquetesJpaRepositorio paquetesJpaRepositorio;
	private final IAgenciasJpaRepositorio agenciasJpaRepositorio;

	public ReservasRepositorioImpl(IReservasJpaRepositorio jpaRepositorio, IReservasJpaMapper jpaMapper,
			IUsuariosJpaRepositorio usuariosJpaRepositorio, IVuelosJpaRepositorio vuelosJpaRepositorio,
			IPaquetesJpaRepositorio paquetesJpaRepositorio, IAgenciasJpaRepositorio agenciasJpaRepositorio) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
		this.usuariosJpaRepositorio = usuariosJpaRepositorio;
		this.vuelosJpaRepositorio = vuelosJpaRepositorio;
		this.paquetesJpaRepositorio = paquetesJpaRepositorio;
		this.agenciasJpaRepositorio = agenciasJpaRepositorio;
	}

	@Override
	public Reservas guardar(Reservas reservas) {
		ReservasJpa entity = jpaMapper.toEntity(reservas);
		entity.setUsuario(usuariosJpaRepositorio.getReferenceById(reservas.getIdUsuario()));
		entity.setVuelo(vuelosJpaRepositorio.getReferenceById(reservas.getIdVuelo()));
		entity.setPaquete(paquetesJpaRepositorio.getReferenceById(reservas.getIdPaquete()));
		entity.setAgencia(agenciasJpaRepositorio.getReferenceById(reservas.getIdAgencia()));
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
