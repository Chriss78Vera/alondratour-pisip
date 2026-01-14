package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.time.LocalDate;
import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IHotelesUseCase;
import com.pisip.alondrabackend.dominio.entidades.Hoteles;
import com.pisip.alondrabackend.dominio.repositorios.IHotelesRepositorio;

public class HotelesUseCaseImpl implements IHotelesUseCase {
	
	private final IHotelesRepositorio repositorio;
	
	
	public HotelesUseCaseImpl(IHotelesRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Hoteles guardar(Hoteles hoteles) {
		// TODO Auto-generated method stub
		return repositorio.guardar(hoteles);
	}

	@Override
	public Hoteles buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(id).orElseThrow(()-> new RuntimeException("Hotel no encontrado"));
	}

	@Override
	public List<Hoteles> listarTodo() {
		// TODO Auto-generated method stub
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repositorio.eliminar(id);
	}

	@Override
	public List<Hoteles> hotelesPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return repositorio.hotelesPorNombre(nombre);
	}

	@Override
	public List<Hoteles> hotelesPorCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return repositorio.hotelesPorCiudad(ciudad);
	}

	@Override
	public List<Hoteles> hotelesPorPais(String pais) {
		// TODO Auto-generated method stub
		return repositorio.hotelesPorPais(pais);
	}

	@Override
	public List<Hoteles> hotelesPorPaisYCiudad(String pais, String ciudad) {
		// TODO Auto-generated method stub
		return repositorio.hotelesPorPaisYCiudad(pais, ciudad);
	}

	@Override
	public List<Hoteles> listarPorFechaDeCheckin(LocalDate fecha) {
		// TODO Auto-generated method stub
		return repositorio.listarPorFechaDeCheckin(fecha);
	}

	@Override
	public List<Hoteles> listarPorFechaDeCheckout(LocalDate fecha) {
		// TODO Auto-generated method stub
		return repositorio.listarPorFechaDeCheckout(fecha);
	}

	@Override
	public List<Hoteles> listarPorRangoDeFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
		// TODO Auto-generated method stub
		return repositorio.listarPorRangoDeFechas(fechaInicial, fechaFinal);
	}

	@Override
	public List<Hoteles> hotelesConfechaExtraCheckin() {
		// TODO Auto-generated method stub
		return repositorio.hotelesConfechaExtraCheckin();
	}

	@Override
	public List<Hoteles> listarPorFechaExtraCheckin(LocalDate fecha) {
		// TODO Auto-generated method stub
		return repositorio.listarPorFechaExtraCheckin(fecha);
	}

	@Override
	public List<Hoteles> listarPorFechaExtraCheckout(LocalDate fecha) {
		// TODO Auto-generated method stub
		return repositorio.listarPorFechaExtraCheckout(fecha);
	}

	@Override
	public List<Hoteles> listarPorRangoDeFechasExtras(LocalDate fechaInicial, LocalDate fechaFinal) {
		// TODO Auto-generated method stub
		return repositorio.listarPorRangoDeFechasExtras(fechaInicial, fechaFinal);
	}

}
