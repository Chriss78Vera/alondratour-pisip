package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.time.LocalDate;
import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IVuelosUseCase;
import com.pisip.alondrabackend.dominio.entidades.Vuelos;
import com.pisip.alondrabackend.dominio.repositorios.IVuelosRepositorio;

public class VuelosUseCaseImpl implements IVuelosUseCase {

	private final IVuelosRepositorio repositorio;
	
	
	public VuelosUseCaseImpl(IVuelosRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Vuelos guardar(Vuelos vuelos) {
		// TODO Auto-generated method stub
		return repositorio.guardar(vuelos);
	}

	@Override
	public Vuelos buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
	}

	@Override
	public List<Vuelos> listarTodo() {
		// TODO Auto-generated method stub
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repositorio.eliminar(id);
	}

	@Override
	public List<Vuelos> listarPorAerolinea(String aerolinea) {
		// TODO Auto-generated method stub
		return repositorio.listarPorAerolinea(aerolinea);
	}

	@Override
	public List<Vuelos> proximosVuelos() {
		// TODO Auto-generated method stub
		return repositorio.proximosVuelos();
	}

	@Override
	public List<Vuelos> listarPorIdPaisDestino(int idPais) {
		return repositorio.listarPorIdPaisDestino(idPais);
	}

	@Override
	public List<Vuelos> listarPorIdCiudadDestino(int idCiudad) {
		return repositorio.listarPorIdCiudadDestino(idCiudad);
	}

	@Override
	public List<Vuelos> listarPorFechaSalida(LocalDate fecha) {
		// TODO Auto-generated method stub
		return repositorio.listarPorFechaSalida(fecha);
	}

	@Override
	public List<Vuelos> listarPorFechaLlegada(LocalDate fecha) {
		// TODO Auto-generated method stub
		return repositorio.listarPorFechaLlegada(fecha);
	}

	@Override
	public List<Vuelos> listarPorRangoFechas(LocalDate inicio, LocalDate fin) {
		// TODO Auto-generated method stub
		return repositorio.listarPorRangoFechas(inicio, fin);
	}

	@Override
	public List<Vuelos> vuelosConFechaExtraSalida() {
		// TODO Auto-generated method stub
		return repositorio.vuelosConFechaExtraSalida();
	}

	@Override
	public List<Vuelos> listarPorFechaExtraSalida(LocalDate fecha) {
		// TODO Auto-generated method stub
		return repositorio.listarPorFechaExtraSalida(fecha);
	}

	@Override
	public List<Vuelos> listarPorFechaExtraLlegada(LocalDate fecha) {
		// TODO Auto-generated method stub
		return repositorio.listarPorFechaExtraLlegada(fecha);
	}

	@Override
	public List<Vuelos> listarPorRangoFechasExtras(LocalDate inicio, LocalDate fin) {
		// TODO Auto-generated method stub
		return repositorio.listarPorRangoFechasExtras(inicio, fin);
	}

}
