package com.pisip.alondrabackend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Paquetes;

public interface IPaquetesRepositorio {
	Paquetes guardar(Paquetes paquetes);

	Optional<Paquetes> buscarPorId(int id);

	List<Paquetes> listarTodo();

	void eliminar(int id);

	List<Paquetes> paquetesPorIdPais(int idPais);

	List<Paquetes> paquetesPorIdCiudad(int idCiudad);

	List<Paquetes> paquetesPorIdPaisYIdCiudad(int idPais, int idCiudad);

	List<Paquetes> paquetesPorIdPaquetesDetalles(int idPaquetesDetalles);

	List<String> paisesDistintos();

	List<String> ciudadesDistintas();
}
