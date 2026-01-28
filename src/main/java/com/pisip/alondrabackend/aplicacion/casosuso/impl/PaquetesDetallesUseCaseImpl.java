package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.time.LocalDate;
import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPaquetesDetallesUseCase;
import com.pisip.alondrabackend.dominio.entidades.PaquetesDetalles;
import com.pisip.alondrabackend.dominio.repositorios.IPaquetesDetallesRepositorio;

public class PaquetesDetallesUseCaseImpl implements IPaquetesDetallesUseCase {

	private final IPaquetesDetallesRepositorio repositorio;

	public PaquetesDetallesUseCaseImpl(IPaquetesDetallesRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public PaquetesDetalles guardar(PaquetesDetalles paquetesDetalles) {
		return repositorio.guardar(paquetesDetalles);
	}

	@Override
	public PaquetesDetalles buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Paquete detalle no encontrado"));
	}

	@Override
	public List<PaquetesDetalles> listarTodo() {
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}

	@Override
	public List<PaquetesDetalles> paquetesDetallesPorHotel(String hotel) {
		return repositorio.paquetesDetallesPorHotel(hotel);
	}

	@Override
	public List<PaquetesDetalles> paquetesDetallesPorRangoFechas(LocalDate inicio, LocalDate fin) {
		return repositorio.paquetesDetallesPorRangoFechas(inicio, fin);
	}
}
