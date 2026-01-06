package com.pisip.alondrabackend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PasajerosJpa;

public interface IPasajerosJpaRepositorio  extends JpaRepository<PasajerosJpa, Integer> {

}
