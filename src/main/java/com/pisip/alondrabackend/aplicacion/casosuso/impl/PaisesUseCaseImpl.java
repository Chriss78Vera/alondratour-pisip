package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPaisesUseCase;
import com.pisip.alondrabackend.dominio.entidades.Paises;
import com.pisip.alondrabackend.dominio.repositorios.IPaisesRepositorio;

public class PaisesUseCaseImpl implements IPaisesUseCase {

	private final IPaisesRepositorio repositorio;

	public PaisesUseCaseImpl(IPaisesRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Paises guardar(Paises paises) {
		return repositorio.guardar(paises);
	}

	@Override
	public Paises buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("País no encontrado"));
	}

	@Override
	public List<Paises> listarTodo() {
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}
}
