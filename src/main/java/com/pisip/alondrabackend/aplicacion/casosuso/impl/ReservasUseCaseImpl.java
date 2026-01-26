package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IReservasUseCase;
import com.pisip.alondrabackend.dominio.entidades.Reservas;
import com.pisip.alondrabackend.dominio.repositorios.IReservasRepositorio;

public class ReservasUseCaseImpl implements IReservasUseCase{
	
	private final IReservasRepositorio repositorio;
	
	public ReservasUseCaseImpl(IReservasRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	

	@Override
	public Reservas crear(Reservas reservas) {
		return repositorio.guardar(reservas);
	}

	@Override
	public Reservas obtenerPorId(int id) {
		return repositorio.bucarPorId(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
	}

	@Override
	public List<Reservas> listar() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);	
	}

}
