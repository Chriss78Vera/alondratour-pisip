package com.pisip.alondrabackend.dominio.repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.PaquetesDetalles;

public interface IPaquetesDetallesRepositorio {
	PaquetesDetalles guardar(PaquetesDetalles paquetesDetalles);

	Optional<PaquetesDetalles> buscarPorId(int id);

	List<PaquetesDetalles> listarTodo();

	void eliminar(int id);

	List<PaquetesDetalles> paquetesDetallesPorRangoFechas(LocalDate inicio, LocalDate fin);
}
