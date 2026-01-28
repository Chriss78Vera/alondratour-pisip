package com.pisip.alondrabackend.dominio.repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Hoteles;


public interface IHotelesRepositorio {
	Hoteles guardar(Hoteles hoteles);
	
	Optional<Hoteles> buscarPorId(int id);
	
	List<Hoteles> listarTodo();
	
	void eliminar(int id);
	
	// Logica de Negocio
	

	List<Hoteles> hotelesPorNombre(String nombre);

	List<Hoteles> hotelesPorIdPaquetesDetalles(int idPaquetesDetalles);

	List<Hoteles> listarPorFechaDeCheckin(LocalDate fecha);

	List<Hoteles> listarPorFechaDeCheckout(LocalDate fecha);

	List<Hoteles> listarPorRangoDeFechas(LocalDate fechaInicial, LocalDate fechaFinal);

	List<Hoteles> hotelesConfechaExtraCheckin();

	List<Hoteles> listarPorFechaExtraCheckin(LocalDate fecha);

	List<Hoteles> listarPorFechaExtraCheckout(LocalDate fecha);

	List<Hoteles> listarPorRangoDeFechasExtras(LocalDate fechaInicial, LocalDate fechaFinal);
	
}
