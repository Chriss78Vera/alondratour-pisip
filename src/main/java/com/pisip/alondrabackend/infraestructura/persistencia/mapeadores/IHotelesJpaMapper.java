package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.Hoteles;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.HotelesJpa;

@Mapper(componentModel = "spring")
public interface IHotelesJpaMapper {

	@Mapping(source = "paquetesDetalles.idPaquetesDetalles", target = "idPaquetesDetalles")
	Hoteles toDomain(HotelesJpa entity);

	@Mapping(target = "paquetesDetalles", ignore = true)
	HotelesJpa toEntity(Hoteles hotel);
}
