package com.pisip.alondrabackend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaisesJpa;

public interface IPaisesJpaRepositorio extends JpaRepository<PaisesJpa, Integer> {
}
