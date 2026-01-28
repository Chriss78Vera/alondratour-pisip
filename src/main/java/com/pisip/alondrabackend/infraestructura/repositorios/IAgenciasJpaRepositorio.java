package com.pisip.alondrabackend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.AgenciasJpa;

public interface IAgenciasJpaRepositorio extends JpaRepository<AgenciasJpa, Integer> {

	List<AgenciasJpa> findByNombre(String nombre);
}
