package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
		Paquetes p = repositorio.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paquete no encontrado"));
		if (!p.isEstado()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paquete no encontrado");
		}
		return p;
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
		return repositorio.paquetesPorPais(pais).stream().filter(Paquetes::isEstado).toList();
	}

	@Override
	public List<Paquetes> paquetesPorCiudad(String ciudad) {
		return repositorio.paquetesPorCiudad(ciudad).stream().filter(Paquetes::isEstado).toList();
	}

	@Override
	public List<Paquetes> paquetesPorPaisYCiudad(String pais, String ciudad) {
		return repositorio.paquetesPorPaisYCiudad(pais, ciudad).stream().filter(Paquetes::isEstado).toList();
	}

	@Override
	public List<Paquetes> paquetesPorIdPaquetesDetalles(int idPaquetesDetalles) {
		return repositorio.paquetesPorIdPaquetesDetalles(idPaquetesDetalles).stream().filter(Paquetes::isEstado).toList();
	}

	@Override
	public List<String> paisesDistintos() {
		return repositorio.listarTodo().stream().filter(Paquetes::isEstado).map(Paquetes::getPais).distinct().toList();
	}

	@Override
	public List<String> ciudadesDistintas() {
		return repositorio.listarTodo().stream().filter(Paquetes::isEstado).map(Paquetes::getCiudad).distinct().toList();
	}
}
