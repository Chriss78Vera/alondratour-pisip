package com.pisip.alondrabackend.aplicacion.casosuso.impl;

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

}
