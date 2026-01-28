package com.pisip.alondrabackend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Paquetes;

public interface IPaquetesRepositorio {
	Paquetes guardar(Paquetes paquetes);

	Optional<Paquetes> buscarPorId(int id);

	List<Paquetes> listarTodo();

	void eliminar(int id);

	List<Paquetes> paquetesPorPais(String pais);

	List<Paquetes> paquetesPorCiudad(String ciudad);

	List<Paquetes> paquetesPorPaisYCiudad(String pais, String ciudad);

	List<Paquetes> paquetesPorIdPaquetesDetalles(int idPaquetesDetalles);

	List<String> paisesDistintos();

	List<String> ciudadesDistintas();
}
