package com.pisip.alondrabackend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Ciudades;

public interface ICiudadesRepositorio {
	Ciudades guardar(Ciudades ciudades);

	Optional<Ciudades> buscarPorId(int id);

	List<Ciudades> listarTodo();

	void eliminar(int id);

	List<Ciudades> buscarPorIdPais(int idPais);
}
