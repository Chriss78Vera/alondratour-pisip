package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IRolUseCase;
import com.pisip.alondrabackend.dominio.entidades.Rol;
import com.pisip.alondrabackend.dominio.repositorios.IRolRepositorio;

public class RolUseCaseImpl implements IRolUseCase {

	private final IRolRepositorio repositorio;

	public RolUseCaseImpl(IRolRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Rol guardar(Rol rol) {
		return repositorio.guardar(rol);
	}

	@Override
	public Rol buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
	}

	@Override
	public List<Rol> listarTodo() {
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}

	@Override
	public Rol buscarPorTipo(String tipo) {
		return repositorio.buscarPorTipo(tipo).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
	}
}
