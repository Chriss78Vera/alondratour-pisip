package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IHotelesUseCase;
import com.pisip.alondrabackend.dominio.entidades.Hoteles;
import com.pisip.alondrabackend.dominio.repositorios.IHotelesRepositorio;

public class HotelesUseCaseImpl implements IHotelesUseCase {

	private final IHotelesRepositorio repositorio;

	public HotelesUseCaseImpl(IHotelesRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Hoteles guardar(Hoteles hoteles) {
		return repositorio.guardar(hoteles);
	}

	@Override
	public Hoteles buscarPorId(int id) {
		Hoteles h = repositorio.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel no encontrado"));
		if (!h.isEstado()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel no encontrado");
		}
		return h;
	}

	@Override
	public List<Hoteles> listarTodo() {
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}

	@Override
	public List<Hoteles> hotelesPorNombre(String nombre) {
		return repositorio.hotelesPorNombre(nombre);
	}

	@Override
	public List<Hoteles> hotelesPorIdPaquetesDetalles(int idPaquetesDetalles) {
		return repositorio.hotelesPorIdPaquetesDetalles(idPaquetesDetalles);
	}
}
