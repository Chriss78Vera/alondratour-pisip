package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.Reservas;

public interface IReservasUseCase {
	
	Reservas crear(Reservas reservas);
	
	Reservas obtenerPorId(int id);
	
	List<Reservas> listar();
	
	void eliminar(int id);

}
