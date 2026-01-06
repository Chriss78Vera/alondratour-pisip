package com.pisip.alondrabackend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.FechadeVueloJpa;

public interface IFechadeVueloJpaRepositorio
        extends JpaRepository<FechadeVueloJpa, Integer> {

}

