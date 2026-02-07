package com.pisip.alondrabackend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Rol;

public interface IRolRepositorio {
	Rol guardar(Rol rol);

	Optional<Rol> buscarPorId(int id);

	List<Rol> listarTodo();

	void eliminar(int id);

	Optional<Rol> buscarPorTipo(String tipo);
}
