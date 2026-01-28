package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.time.LocalDate;
import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IServiciosExtraUseCase;
import com.pisip.alondrabackend.dominio.entidades.ServiciosExtra;
import com.pisip.alondrabackend.dominio.repositorios.IServiciosExtraRepositorio;

public class ServiciosExtraUseCaseImpl implements IServiciosExtraUseCase {

	private final IServiciosExtraRepositorio repositorio;

	public ServiciosExtraUseCaseImpl(IServiciosExtraRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public ServiciosExtra guardar(ServiciosExtra serviciosExtra) {
		return repositorio.guardar(serviciosExtra);
	}

	@Override
	public ServiciosExtra buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Servicio extra no encontrado"));
	}

	@Override
	public List<ServiciosExtra> listarTodo() {
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}

	@Override
	public List<ServiciosExtra> serviciosExtraPorIdReserva(int idReserva) {
		return repositorio.serviciosExtraPorIdReserva(idReserva);
	}

	@Override
	public List<ServiciosExtra> serviciosExtraPorTipoServicio(String tipoServicio) {
		return repositorio.serviciosExtraPorTipoServicio(tipoServicio);
	}

	@Override
	public List<ServiciosExtra> serviciosExtraPorRangoFechas(LocalDate inicio, LocalDate fin) {
		return repositorio.serviciosExtraPorRangoFechas(inicio, fin);
	}
}
