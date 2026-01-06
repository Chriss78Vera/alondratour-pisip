package com.pisip.alondrabackend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaquetesJpa;

public interface IPaquetesJpaRepositorio extends JpaRepository<PaquetesJpa, Integer> {

}
