package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.time.LocalDate;
import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.PaquetesDetalles;

public interface IPaquetesDetallesUseCase {
	PaquetesDetalles guardar(PaquetesDetalles paquetesDetalles);

	PaquetesDetalles buscarPorId(int id);

	List<PaquetesDetalles> listarTodo();

	void eliminar(int id);

	List<PaquetesDetalles> paquetesDetallesPorHotel(String hotel);

	List<PaquetesDetalles> paquetesDetallesPorRangoFechas(LocalDate inicio, LocalDate fin);
}
