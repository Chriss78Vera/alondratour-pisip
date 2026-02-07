package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.springframework.stereotype.Component;

import com.pisip.alondrabackend.dominio.entidades.Vuelos;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.VuelosJpa;

@Component
public class VuelosJpaMapperImpl implements IVuelosJpaMapper {

	@Override
	public Vuelos toDomain(VuelosJpa entity) {
		if (entity == null) {
			return null;
		}
		int idPaisDestino = entity.getDestinoPais() != null ? entity.getDestinoPais().getIdPais() : 0;
		int idCiudadDestino = entity.getDestinoCiudad() != null ? entity.getDestinoCiudad().getIdCiudad() : 0;
		String nombrePaisDestino = entity.getDestinoPais() != null ? entity.getDestinoPais().getNombre() : null;
		String nombreCiudadDestino = entity.getDestinoCiudad() != null ? entity.getDestinoCiudad().getNombre() : null;
		return new Vuelos(
				entity.getIdVuelo(),
				entity.getAerolinea(),
				idPaisDestino,
				idCiudadDestino,
				nombrePaisDestino,
				nombreCiudadDestino,
				entity.getFechaSalida(),
				entity.getFechaLlegada(),
				entity.getFechaExtraSalida(),
				entity.getFechaExtraLlegada());
	}

	@Override
	public VuelosJpa toEntity(Vuelos vuelos) {
		if (vuelos == null) {
			return null;
		}
		VuelosJpa jpa = new VuelosJpa();
		jpa.setIdVuelo(vuelos.getIdVuelo());
		jpa.setAerolinea(vuelos.getAerolinea());
		// destinoPais y destinoCiudad se asignan en el adaptador
		jpa.setFechaSalida(vuelos.getFechaSalida());
		jpa.setFechaLlegada(vuelos.getFechaLlegada());
		jpa.setFechaExtraSalida(vuelos.getFechaExtraSalida());
		jpa.setFechaExtraLlegada(vuelos.getFechaExtraLlegada());
		return jpa;
	}
}
