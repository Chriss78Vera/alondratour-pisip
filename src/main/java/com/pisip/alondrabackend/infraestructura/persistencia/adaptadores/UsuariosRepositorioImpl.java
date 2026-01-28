package com.pisip.alondrabackend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Usuarios;
import com.pisip.alondrabackend.dominio.repositorios.IUsuariosRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.UsuariosJpa;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IUsuariosJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IUsuariosJpaRepositorio;

public class UsuariosRepositorioImpl implements IUsuariosRepositorio {

	private final IUsuariosJpaRepositorio jpaRepositorio;
	private final IUsuariosJpaMapper jpaMapper;

	public UsuariosRepositorioImpl(IUsuariosJpaRepositorio jpaRepositorio, IUsuariosJpaMapper jpaMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.jpaMapper = jpaMapper;
	}

	@Override
	public Usuarios guardar(Usuarios usuarios) {
		UsuariosJpa entity = jpaMapper.toEntity(usuarios);
		UsuariosJpa guardado = jpaRepositorio.save(entity);
		return jpaMapper.toDomain(guardado);
	}

	@Override
	public Optional<Usuarios> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(jpaMapper::toDomain);
	}

	@Override
	public List<Usuarios> listarTodo() {
		return jpaRepositorio.findAll().stream().map(jpaMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
	}

	@Override
	public Optional<Usuarios> buscarPorCedula(String cedula) {
		return jpaRepositorio.findByCedula(cedula).map(jpaMapper::toDomain);
	}

	@Override
	public Optional<Usuarios> buscarPorCorreo(String correo) {
		return jpaRepositorio.findByCorreo(correo).map(jpaMapper::toDomain);
	}

	@Override
	public List<Usuarios> listarPorRol(String rol) {
		return jpaRepositorio.findByRol(rol).stream().map(jpaMapper::toDomain).toList();
	}
}
