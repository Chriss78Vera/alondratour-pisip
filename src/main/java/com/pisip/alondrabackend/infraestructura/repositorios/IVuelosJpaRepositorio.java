package com.pisip.alondrabackend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.VuelosJpa;

public interface IVuelosJpaRepositorio extends JpaRepository<VuelosJpa, Integer> {

}
