package com.pisip.alondrabackend.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.RolJpa;

public interface IRolJpaRepositorio extends JpaRepository<RolJpa, Integer> {

	Optional<RolJpa> findByTipo(String tipo);
}
