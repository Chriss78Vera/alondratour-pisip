package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IHotelesReservasUseCase;
import com.pisip.alondrabackend.dominio.entidades.HotelesReservas;
import com.pisip.alondrabackend.dominio.repositorios.IHotelesReservasRepositorio;

public class HotelesReservasUseCaseImpl implements IHotelesReservasUseCase {

	private final IHotelesReservasRepositorio repositorio;

	public HotelesReservasUseCaseImpl(IHotelesReservasRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public HotelesReservas guardar(HotelesReservas hotelesReservas) {
		return repositorio.guardar(hotelesReservas);
	}

	@Override
	public HotelesReservas buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("HotelReserva no encontrado"));
	}

	@Override
	public List<HotelesReservas> listarTodo() {
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}

	@Override
	public List<HotelesReservas> hotelesReservasPorIdReserva(int idReserva) {
		return repositorio.hotelesReservasPorIdReserva(idReserva);
	}

	@Override
	public List<HotelesReservas> hotelesReservasPorIdHotel(int idHotel) {
		return repositorio.hotelesReservasPorIdHotel(idHotel);
	}
}
