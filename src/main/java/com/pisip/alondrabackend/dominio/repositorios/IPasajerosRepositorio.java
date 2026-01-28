package com.pisip.alondrabackend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Pasajeros;

public interface IPasajerosRepositorio {
	
	Pasajeros guardar(Pasajeros pasajeros);
	
	Optional<Pasajeros> bucarPorId(int id);
	
	List<Pasajeros> listarTodos();
	
	void eliminar (int id);

}
