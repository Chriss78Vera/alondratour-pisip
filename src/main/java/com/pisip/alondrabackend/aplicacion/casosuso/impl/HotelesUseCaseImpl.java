package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IHotelesUseCase;
import com.pisip.alondrabackend.dominio.entidades.Hoteles;
import com.pisip.alondrabackend.dominio.repositorios.IHotelesRepositorio;

public class HotelesUseCaseImpl implements IHotelesUseCase {
	
	private final IHotelesRepositorio repositorio;
	
	
	public HotelesUseCaseImpl(IHotelesRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Hoteles guardar(Hoteles hoteles) {
		// TODO Auto-generated method stub
		return repositorio.guardar(hoteles);
	}

	@Override
	public Hoteles buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(id).orElseThrow(()-> new RuntimeException("Hotel no encontrado"));
	}

	@Override
	public List<Hoteles> listarTodo() {
		// TODO Auto-generated method stub
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repositorio.eliminar(id);
	}

}
