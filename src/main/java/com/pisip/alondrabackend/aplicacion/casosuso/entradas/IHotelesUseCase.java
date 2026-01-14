package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.time.LocalDate;
import java.util.List;


import com.pisip.alondrabackend.dominio.entidades.Hoteles;

public interface IHotelesUseCase {
	Hoteles guardar(Hoteles hoteles);

	Hoteles buscarPorId(int id);

	List<Hoteles> listarTodo();

	void eliminar(int id);

	/*
	 * Consultas para la logica de negocio
	 * 
	 */

	List<Hoteles> hotelesPorNombre(String nombre);

	List<Hoteles> hotelesPorCiudad(String ciudad);

	List<Hoteles> hotelesPorPais(String pais);

	List<Hoteles> hotelesPorPaisYCiudad(String pais, String ciudad);

	List<Hoteles> listarPorFechaDeCheckin(LocalDate fecha);

	List<Hoteles> listarPorFechaDeCheckout(LocalDate fecha);

	List<Hoteles> listarPorRangoDeFechas(LocalDate fechaInicial, LocalDate fechaFinal);

	List<Hoteles> hotelesConfechaExtraCheckin();

	List<Hoteles> listarPorFechaExtraCheckin(LocalDate fecha);

	List<Hoteles> listarPorFechaExtraCheckout(LocalDate fecha);

	List<Hoteles> listarPorRangoDeFechasExtras(LocalDate fechaInicial, LocalDate fechaFinal);
}
