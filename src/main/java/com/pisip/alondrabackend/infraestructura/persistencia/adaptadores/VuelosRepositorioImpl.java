package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Vuelos;
import com.pisip.alondrabackend.dominio.repositorios.IVuelosRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.VuelosJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IVuelosJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IVuelosJpaRepositorio;

public class VuelosRepositorioImpl implements IVuelosRepositorio {
	
	private final IVuelosJpaRepositorio jpaRepositorio;
	private final IVuelosJpaMapper jpaMapper;
	
	

	public VuelosRepositorioImpl(IVuelosJpaRepositorio jpaRepositorio, IVuelosJpaMapper jpaMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
	}

	@Override
	public Vuelos guardar(Vuelos vuelos) {
		VuelosJpa entity = jpaMapper.toEntity(vuelos);
		VuelosJpa guardado = jpaRepositorio.save(entity);
		// TODO Auto-generated method stub
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Vuelos> buscarPorId(int id) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Vuelos> listarTodo() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(id);
	}
	
	

	@Override
	public List<Vuelos> listarPorAerolinea(String aerolinea) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorAerolinea(aerolinea).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Vuelos> proximosVuelos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.proximosVuelos().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Vuelos> listarPorOrigen(String origen) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorOrigen(origen).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Vuelos> listarPorDestino(String destino) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorDestino(destino).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Vuelos> listarPorFechaSalida(LocalDate fecha) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorFechaDeSalida(fecha).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Vuelos> listarPorFechaLlegada(LocalDate fecha) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorFechaDeLlegada(fecha).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Vuelos> listarPorRangoFechas(LocalDate inicio, LocalDate fin) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorRangoDeFechas(inicio, fin).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Vuelos> vuelosConFechaExtraSalida() {
		// TODO Auto-generated method stub
		return jpaRepositorio.vuelosConFechaExtraSalida().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Vuelos> listarPorFechaExtraSalida(LocalDate fecha) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorFechaExtraDeSalida(fecha).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Vuelos> listarPorFechaExtraLlegada(LocalDate fecha) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorFechaExtraDeLlegada(fecha).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Vuelos> listarPorRangoFechasExtras(LocalDate inicio, LocalDate fin) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorRangoDeFechasExtras(inicio, fin).stream().map(jpaMapper::toDomain).toList();
	}

	
}
