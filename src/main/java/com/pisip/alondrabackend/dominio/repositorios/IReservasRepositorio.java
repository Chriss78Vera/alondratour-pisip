package com.pisip.alondrabackend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Reservas;

public interface IReservasRepositorio {
	
	Reservas guardar(Reservas reservas);
	
	Optional<Reservas> bucarPorId(int id);
	
	List<Reservas> listarTodos();
	
	void eliminar (int id);

}
