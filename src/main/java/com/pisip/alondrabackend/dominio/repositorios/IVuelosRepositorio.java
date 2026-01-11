package com.pisip.alondrabackend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Vuelos;

public interface IVuelosRepositorio {
	Vuelos guardar(Vuelos vuelos);
	
	Optional<Vuelos> buscarPorId(int id);
	
	List<Vuelos> listarTodo();
	
	void eliminar(int id);
}
