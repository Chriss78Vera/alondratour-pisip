package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Hoteles;
import com.pisip.alondrabackend.dominio.repositorios.IHotelesRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.HotelesJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IHotelesJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IHotelesJpaRepositorio;

public class HotelesRepositorioImpl implements IHotelesRepositorio {

	private final IHotelesJpaRepositorio jpaRepositorio;
	private final IHotelesJpaMapper jpaMapper;
	
	
	
	public HotelesRepositorioImpl(IHotelesJpaRepositorio jpaRepositorio, IHotelesJpaMapper jpaMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
	}

	@Override
	public Hoteles guardar(Hoteles hoteles) {
		HotelesJpa entity = jpaMapper.toEntity(hoteles);
		HotelesJpa guardado = jpaRepositorio.save(entity);
		// TODO Auto-generated method stub
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Hoteles> buscarPorId(int id) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Hoteles> listarTodo() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(id);
	}

	
	@Override
	public List<Hoteles> hotelesPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return jpaRepositorio.hotelesPorNombre(nombre).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Hoteles> hotelesPorCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return jpaRepositorio.hotelesPorCiudad(ciudad).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Hoteles> hotelesPorPais(String pais) {
		// TODO Auto-generated method stub
		return jpaRepositorio.hotelesPorPais(pais).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Hoteles> hotelesPorPaisYCiudad(String pais, String ciudad) {
		// TODO Auto-generated method stub
		return jpaRepositorio.hotelesPorPaisYCiudad(pais, ciudad).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Hoteles> listarPorFechaDeCheckin(LocalDate fecha) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorFechaDeCheckin(fecha).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Hoteles> listarPorFechaDeCheckout(LocalDate fecha) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorFechaDeCheckout(fecha).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Hoteles> listarPorRangoDeFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorRangoDeFechas(fechaInicial, fechaFinal).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Hoteles> hotelesConfechaExtraCheckin() {
		// TODO Auto-generated method stub
		return jpaRepositorio.hotelesConfechaExtraCheckin().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Hoteles> listarPorFechaExtraCheckin(LocalDate fecha) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorFechaExtraCheckin(fecha).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Hoteles> listarPorFechaExtraCheckout(LocalDate fecha) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorFechaExtraCheckout(fecha).stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public List<Hoteles> listarPorRangoDeFechasExtras(LocalDate fechaInicial, LocalDate fechaFinal) {
		// TODO Auto-generated method stub
		return jpaRepositorio.listarPorRangoDeFechasExtras(fechaInicial, fechaFinal).stream().map(jpaMapper::toDomain).toList();
	}

}
