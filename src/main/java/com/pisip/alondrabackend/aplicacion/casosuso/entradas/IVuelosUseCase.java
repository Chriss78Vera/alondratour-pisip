package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.time.LocalDate;
import java.util.List;


import com.pisip.alondrabackend.dominio.entidades.Vuelos;

public interface IVuelosUseCase {
	Vuelos guardar(Vuelos vuelos);
	
	Vuelos buscarPorId(int id);
	
	List<Vuelos> listarTodo();
	
	void eliminar(int id);
	
	/*
	 * Consultas extras de logica de negocio
	 */
    List<Vuelos> listarPorAerolinea(String aerolinea);

    List<Vuelos> proximosVuelos();

    List<Vuelos> listarPorIdPaisDestino(int idPais);

    List<Vuelos> listarPorIdCiudadDestino(int idCiudad);

    List<Vuelos> listarPorFechaSalida(LocalDate fecha);

    List<Vuelos> listarPorFechaLlegada(LocalDate fecha);

    List<Vuelos> listarPorRangoFechas(LocalDate inicio, LocalDate fin);

    List<Vuelos> vuelosConFechaExtraSalida();

    List<Vuelos> listarPorFechaExtraSalida(LocalDate fecha);

    List<Vuelos> listarPorFechaExtraLlegada(LocalDate fecha);

    List<Vuelos> listarPorRangoFechasExtras(LocalDate inicio, LocalDate fin);
}
