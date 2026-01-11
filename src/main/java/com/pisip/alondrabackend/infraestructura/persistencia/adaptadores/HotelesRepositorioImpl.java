package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Hoteles;
import com.pisip.alondrabackend.dominio.repositorios.IHotelesRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.HotelesJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IHotelesJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IHotelesJpaRepositorio;

public class HotelesRepositorioImpl implements IHotelesRepositorio {

	private final IHotelesJpaRepositorio jpaRepositorio;
	private final IHotelesJpaMapper jpaMapper;
	
	
	
	public HotelesRepositorioImpl(IHotelesJpaRepositorio jpaRepositorio, IHotelesJpaMapper jpaMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
	}

	@Override
	public Hoteles guardar(Hoteles hoteles) {
		HotelesJpa entity = jpaMapper.toEntity(hoteles);
		HotelesJpa guardado = jpaRepositorio.save(entity);
		// TODO Auto-generated method stub
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Hoteles> buscarPorId(int id) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Hoteles> listarTodo() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(id);
	}

}
