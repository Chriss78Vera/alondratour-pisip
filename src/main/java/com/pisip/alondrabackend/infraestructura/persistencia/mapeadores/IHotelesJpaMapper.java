package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Hoteles;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.HotelesJpa;

@Mapper(componentModel = "spring")
public interface IHotelesJpaMapper {
	Hoteles toDomain(HotelesJpa entity);

	HotelesJpa toEntity(Hoteles vuelos);
}
