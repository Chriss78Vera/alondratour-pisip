package com.pisip.alondrabackend.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IHotelesUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPasajerosUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IReservasUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IVuelosUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.HotelesUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.PasajerosUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.ReservasUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.VuelosUseCaseImpl;
import com.pisip.alondrabackend.dominio.repositorios.IHotelesRepositorio;
import com.pisip.alondrabackend.dominio.repositorios.IPasajerosRepositorio;
import com.pisip.alondrabackend.dominio.repositorios.IReservasRepositorio;
import com.pisip.alondrabackend.dominio.repositorios.IVuelosRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.HotelesRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.PasajerosRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.ReservasRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.VuelosRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IHotelesJpaMapper;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IPasajerosJpaMapper;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IReservasJpaMapper;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IVuelosJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IHotelesJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IPasajerosJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IReservasJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IVuelosJpaRepositorio;

@Configuration
public class ConfiguracionGeneral {
	@Bean
	IHotelesRepositorio HotelesRepositorio(IHotelesJpaRepositorio jpaRepository, IHotelesJpaMapper mapper) {
		return new HotelesRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IHotelesUseCase HotelesUseCase(IHotelesRepositorio repositorio) {
		return new HotelesUseCaseImpl(repositorio);
	}

	@Bean
	IVuelosRepositorio VuelosRepositorio(IVuelosJpaRepositorio jpaRepository, IVuelosJpaMapper mapper) {
		return new VuelosRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IVuelosUseCase VuelosUseCase(IVuelosRepositorio repositorio) {
		return new VuelosUseCaseImpl(repositorio);
	}
	
	
	@Bean
	IPasajerosRepositorio PasajerosRepositorio(IPasajerosJpaRepositorio jpaRepository, IPasajerosJpaMapper mapper) {
		return new PasajerosRepositorioImpl(jpaRepository, mapper);
	}
	
	@Bean
	IPasajerosUseCase PasajerosUseCase(IPasajerosRepositorio repositorio) {
		return new PasajerosUseCaseImpl(repositorio);
	}
	
	@Bean
	IReservasRepositorio ReservasRepositorio(IReservasJpaRepositorio jpaRepository, IReservasJpaMapper mapper) {
		return new ReservasRepositorioImpl(jpaRepository, mapper);
	}
	
	@Bean
	IReservasUseCase ReservasUseCase(IReservasRepositorio repositorio) {
		return new ReservasUseCaseImpl(repositorio);
	}
	
	
}
