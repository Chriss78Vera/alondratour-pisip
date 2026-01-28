package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPaquetesUseCase;
import com.pisip.alondrabackend.dominio.entidades.Paquetes;
import com.pisip.alondrabackend.dominio.repositorios.IPaquetesRepositorio;

public class PaquetesUseCaseImpl implements IPaquetesUseCase {

	private final IPaquetesRepositorio repositorio;

	public PaquetesUseCaseImpl(IPaquetesRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Paquetes guardar(Paquetes paquetes) {
		return repositorio.guardar(paquetes);
	}

	@Override
	public Paquetes buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Paquete no encontrado"));
	}

	@Override
	public List<Paquetes> listarTodo() {
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}

	@Override
	public List<Paquetes> paquetesPorPais(String pais) {
		return repositorio.paquetesPorPais(pais);
	}

	@Override
	public List<Paquetes> paquetesPorCiudad(String ciudad) {
		return repositorio.paquetesPorCiudad(ciudad);
	}

	@Override
	public List<Paquetes> paquetesPorPaisYCiudad(String pais, String ciudad) {
		return repositorio.paquetesPorPaisYCiudad(pais, ciudad);
	}

	@Override
	public List<Paquetes> paquetesPorIdPaquetesDetalles(int idPaquetesDetalles) {
		return repositorio.paquetesPorIdPaquetesDetalles(idPaquetesDetalles);
	}
}
