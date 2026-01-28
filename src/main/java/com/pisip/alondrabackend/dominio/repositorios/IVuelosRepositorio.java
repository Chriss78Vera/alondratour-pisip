package com.pisip.alondrabackend.dominio.repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Vuelos;

public interface IVuelosRepositorio {
	Vuelos guardar(Vuelos vuelos);
	
	Optional<Vuelos> buscarPorId(int id);
	
	List<Vuelos> listarTodo();
	
	void eliminar(int id);
	
	/*
	 * Consultas extras de logica de negocio
	 */
    List<Vuelos> listarPorAerolinea(String aerolinea);

    List<Vuelos> proximosVuelos();

    List<Vuelos> listarPorOrigen(String origen);

    List<Vuelos> listarPorDestino(String destino);

    List<Vuelos> listarPorFechaSalida(LocalDate fecha);

    List<Vuelos> listarPorFechaLlegada(LocalDate fecha);

    List<Vuelos> listarPorRangoFechas(LocalDate inicio, LocalDate fin);

    List<Vuelos> vuelosConFechaExtraSalida();

    List<Vuelos> listarPorFechaExtraSalida(LocalDate fecha);

    List<Vuelos> listarPorFechaExtraLlegada(LocalDate fecha);

    List<Vuelos> listarPorRangoFechasExtras(LocalDate inicio, LocalDate fin);
}
