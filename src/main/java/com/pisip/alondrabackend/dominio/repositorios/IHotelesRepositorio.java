package com.pisip.alondrabackend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Hoteles;

public interface IHotelesRepositorio {
	Hoteles guardar(Hoteles hoteles);

	Optional<Hoteles> buscarPorId(int id);

	List<Hoteles> listarTodo();

	void eliminar(int id);

	List<Hoteles> hotelesPorNombre(String nombre);

	List<Hoteles> hotelesPorIdPaquetesDetalles(int idPaquetesDetalles);
}
