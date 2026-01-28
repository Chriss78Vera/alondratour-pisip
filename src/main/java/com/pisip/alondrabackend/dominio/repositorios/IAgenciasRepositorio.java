package com.pisip.alondrabackend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Agencias;

public interface IAgenciasRepositorio {
	Agencias guardar(Agencias agencias);

	Optional<Agencias> buscarPorId(int id);

	List<Agencias> listarTodo();

	void eliminar(int id);

	List<Agencias> agenciasPorNombre(String nombre);
}
