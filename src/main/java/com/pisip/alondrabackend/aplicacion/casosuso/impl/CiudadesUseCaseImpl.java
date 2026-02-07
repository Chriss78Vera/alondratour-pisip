package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.ICiudadesUseCase;
import com.pisip.alondrabackend.dominio.entidades.Ciudades;
import com.pisip.alondrabackend.dominio.repositorios.ICiudadesRepositorio;

public class CiudadesUseCaseImpl implements ICiudadesUseCase {

	private final ICiudadesRepositorio repositorio;

	public CiudadesUseCaseImpl(ICiudadesRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Ciudades guardar(Ciudades ciudades) {
		return repositorio.guardar(ciudades);
	}

	@Override
	public Ciudades buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));
	}

	@Override
	public List<Ciudades> listarTodo() {
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}

	@Override
	public List<Ciudades> buscarPorIdPais(int idPais) {
		return repositorio.buscarPorIdPais(idPais);
	}
}
