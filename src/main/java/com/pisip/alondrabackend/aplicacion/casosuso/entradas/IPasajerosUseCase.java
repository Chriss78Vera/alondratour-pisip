package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.Pasajeros;

public interface IPasajerosUseCase {
	
	Pasajeros crear(Pasajeros pasajeros);
	
	Pasajeros obtenerPorId(int id);
	
	List<Pasajeros> listar();
	
	void eliminar(int id);

}
