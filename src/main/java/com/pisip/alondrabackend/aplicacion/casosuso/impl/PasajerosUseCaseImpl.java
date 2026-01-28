package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPasajerosUseCase;
import com.pisip.alondrabackend.dominio.entidades.Pasajeros;
import com.pisip.alondrabackend.dominio.repositorios.IPasajerosRepositorio;

public class PasajerosUseCaseImpl implements IPasajerosUseCase{
	
	private final IPasajerosRepositorio repositorio;
	
	public PasajerosUseCaseImpl(IPasajerosRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Pasajeros crear(Pasajeros pasajeros) {
		return repositorio.guardar(pasajeros);
	}

	@Override
	public Pasajeros obtenerPorId(int id) {
		return repositorio.bucarPorId(id).orElseThrow(() -> new RuntimeException("Pasajero no encontrado"));
	}

	@Override
	public List<Pasajeros> listar() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);	
		
	}



}
