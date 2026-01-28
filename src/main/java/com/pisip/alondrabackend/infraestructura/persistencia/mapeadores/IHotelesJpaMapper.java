package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.Hoteles;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.HotelesJpa;

@Mapper(componentModel = "spring")
public interface IHotelesJpaMapper {
	Hoteles toDomain(HotelesJpa entity);

	@Mapping(target = "reservas", ignore = true)
	HotelesJpa toEntity(Hoteles hotel);
}
