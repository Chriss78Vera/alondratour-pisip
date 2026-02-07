package com.pisip.alondrabackend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.CiudadesJpa;

public interface ICiudadesJpaRepositorio extends JpaRepository<CiudadesJpa, Integer> {

	List<CiudadesJpa> findByPais_IdPais(int idPais);
}
