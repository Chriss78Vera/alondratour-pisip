package com.pisip.alondrabackend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Paises;

public interface IPaisesRepositorio {
	Paises guardar(Paises paises);

	Optional<Paises> buscarPorId(int id);

	List<Paises> listarTodo();

	void eliminar(int id);
}
