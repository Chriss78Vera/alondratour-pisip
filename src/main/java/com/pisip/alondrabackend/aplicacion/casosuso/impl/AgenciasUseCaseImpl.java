package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IAgenciasUseCase;
import com.pisip.alondrabackend.dominio.entidades.Agencias;
import com.pisip.alondrabackend.dominio.repositorios.IAgenciasRepositorio;

public class AgenciasUseCaseImpl implements IAgenciasUseCase {

	private final IAgenciasRepositorio repositorio;

	public AgenciasUseCaseImpl(IAgenciasRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Agencias guardar(Agencias agencias) {
		return repositorio.guardar(agencias);
	}

	@Override
	public Agencias buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Agencia no encontrada"));
	}

	@Override
	public List<Agencias> listarTodo() {
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}

	@Override
	public List<Agencias> agenciasPorNombre(String nombre) {
		return repositorio.agenciasPorNombre(nombre);
	}
}
