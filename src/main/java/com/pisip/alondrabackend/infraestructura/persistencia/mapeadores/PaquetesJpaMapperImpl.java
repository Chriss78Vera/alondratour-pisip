package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.springframework.stereotype.Component;

import com.pisip.alondrabackend.dominio.entidades.Paquetes;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaquetesJpa;

@Component
public class PaquetesJpaMapperImpl implements IPaquetesJpaMapper {

	@Override
	public Paquetes toDomain(PaquetesJpa entity) {
		if (entity == null) {
			return null;
		}
		int idPais = entity.getPais() != null ? entity.getPais().getIdPais() : 0;
		int idCiudad = entity.getCiudad() != null ? entity.getCiudad().getIdCiudad() : 0;
		String nombrePais = entity.getPais() != null ? entity.getPais().getNombre() : null;
		String nombreCiudad = entity.getCiudad() != null ? entity.getCiudad().getNombre() : null;
		return new Paquetes(
				entity.getIdPaquetes(),
				entity.getPaquetesDetalles() != null ? entity.getPaquetesDetalles().getIdPaquetesDetalles() : 0,
				entity.getNombre(),
				entity.getDescripcion(),
				idPais,
				idCiudad,
				nombrePais,
				nombreCiudad,
				entity.isEstado());
	}

	@Override
	public PaquetesJpa toEntity(Paquetes paquetes) {
		if (paquetes == null) {
			return null;
		}
		PaquetesJpa jpa = new PaquetesJpa();
		jpa.setIdPaquetes(paquetes.getIdPaquete());
		// paquetesDetalles se asigna en el adaptador
		jpa.setNombre(paquetes.getNombre());
		jpa.setDescripcion(paquetes.getDescripcion());
		// pais y ciudad se asignan en el adaptador
		jpa.setEstado(paquetes.isEstado());
		return jpa;
	}
}
