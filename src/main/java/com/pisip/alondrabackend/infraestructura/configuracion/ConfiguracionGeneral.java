package com.pisip.alondrabackend.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IAgenciasUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IAuthUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IHotelesReservasUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IHotelesUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPaquetesDetallesUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPaquetesUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPasajerosUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IReservasUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IServiciosExtraUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IUsuariosUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IVuelosUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.AgenciasUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.AuthUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.HotelesReservasUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.HotelesUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.PaquetesDetallesUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.PaquetesUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.PasajerosUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.ReservasUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.ServiciosExtraUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.UsuariosUseCaseImpl;
import com.pisip.alondrabackend.aplicacion.casosuso.impl.VuelosUseCaseImpl;
import com.pisip.alondrabackend.dominio.repositorios.IAgenciasRepositorio;
import com.pisip.alondrabackend.dominio.repositorios.IHotelesRepositorio;
import com.pisip.alondrabackend.dominio.repositorios.IHotelesReservasRepositorio;
import com.pisip.alondrabackend.dominio.repositorios.IPaquetesDetallesRepositorio;
import com.pisip.alondrabackend.dominio.repositorios.IPaquetesRepositorio;
import com.pisip.alondrabackend.dominio.repositorios.IPasajerosRepositorio;
import com.pisip.alondrabackend.dominio.repositorios.IReservasRepositorio;
import com.pisip.alondrabackend.dominio.repositorios.IServiciosExtraRepositorio;
import com.pisip.alondrabackend.dominio.repositorios.IUsuariosRepositorio;
import com.pisip.alondrabackend.dominio.repositorios.IVuelosRepositorio;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.AgenciasRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.HotelesRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.HotelesReservasRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.PaquetesDetallesRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.PaquetesRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.PasajerosRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.ReservasRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.ServiciosExtraRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.UsuariosRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.adaptadores.VuelosRepositorioImpl;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IAgenciasJpaMapper;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IHotelesJpaMapper;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IHotelesReservasJpaMapper;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IPaquetesDetallesJpaMapper;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IPaquetesJpaMapper;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IPasajerosJpaMapper;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IReservasJpaMapper;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IServiciosExtraJpaMapper;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IUsuariosJpaMapper;
import com.pisip.alondrabackend.infraestructura.persistencia.mapeadores.IVuelosJpaMapper;
import com.pisip.alondrabackend.infraestructura.repositorios.IAgenciasJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IHotelesJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IHotelesReservasJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IPaquetesDetallesJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IPaquetesJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IPasajerosJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IReservasJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IServiciosExtraJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IUsuariosJpaRepositorio;
import com.pisip.alondrabackend.infraestructura.repositorios.IVuelosJpaRepositorio;

@Configuration
public class ConfiguracionGeneral {
	@Bean
	IHotelesRepositorio HotelesRepositorio(IHotelesJpaRepositorio jpaRepository, IHotelesJpaMapper mapper,
			IPaquetesDetallesJpaRepositorio paquetesDetallesJpaRepositorio) {
		return new HotelesRepositorioImpl(jpaRepository, mapper, paquetesDetallesJpaRepositorio);
	}

	@Bean
	IHotelesUseCase HotelesUseCase(IHotelesRepositorio repositorio) {
		return new HotelesUseCaseImpl(repositorio);
	}

	@Bean
	IHotelesReservasRepositorio HotelesReservasRepositorio(IHotelesReservasJpaRepositorio jpaRepository,
			IHotelesReservasJpaMapper mapper, IReservasJpaRepositorio reservasJpaRepositorio,
			IHotelesJpaRepositorio hotelesJpaRepositorio) {
		return new HotelesReservasRepositorioImpl(jpaRepository, mapper, reservasJpaRepositorio, hotelesJpaRepositorio);
	}

	@Bean
	IHotelesReservasUseCase HotelesReservasUseCase(IHotelesReservasRepositorio repositorio) {
		return new HotelesReservasUseCaseImpl(repositorio);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	IAuthUseCase AuthUseCase(IUsuariosRepositorio usuariosRepositorio, PasswordEncoder passwordEncoder) {
		return new AuthUseCaseImpl(usuariosRepositorio, passwordEncoder);
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
	IPasajerosRepositorio PasajerosRepositorio(IPasajerosJpaRepositorio jpaRepository, IPasajerosJpaMapper mapper,
			IReservasJpaRepositorio reservasJpaRepositorio) {
		return new PasajerosRepositorioImpl(jpaRepository, mapper, reservasJpaRepositorio);
	}
	
	@Bean
	IPasajerosUseCase PasajerosUseCase(IPasajerosRepositorio repositorio) {
		return new PasajerosUseCaseImpl(repositorio);
	}
	
	@Bean
	IReservasRepositorio ReservasRepositorio(IReservasJpaRepositorio jpaRepository, IReservasJpaMapper mapper,
			IUsuariosJpaRepositorio usuariosJpaRepositorio, IVuelosJpaRepositorio vuelosJpaRepositorio,
			IPaquetesJpaRepositorio paquetesJpaRepositorio, IAgenciasJpaRepositorio agenciasJpaRepositorio) {
		return new ReservasRepositorioImpl(jpaRepository, mapper, usuariosJpaRepositorio, vuelosJpaRepositorio,
				paquetesJpaRepositorio, agenciasJpaRepositorio);
	}
	
	@Bean
	IReservasUseCase ReservasUseCase(IReservasRepositorio repositorio) {
		return new ReservasUseCaseImpl(repositorio);
	}

	@Bean
	IPaquetesRepositorio PaquetesRepositorio(IPaquetesJpaRepositorio jpaRepository, IPaquetesJpaMapper mapper,
			IPaquetesDetallesJpaRepositorio paquetesDetallesJpaRepositorio) {
		return new PaquetesRepositorioImpl(jpaRepository, mapper, paquetesDetallesJpaRepositorio);
	}

	@Bean
	IPaquetesUseCase PaquetesUseCase(IPaquetesRepositorio repositorio) {
		return new PaquetesUseCaseImpl(repositorio);
	}

	@Bean
	IUsuariosRepositorio UsuariosRepositorio(IUsuariosJpaRepositorio jpaRepository, IUsuariosJpaMapper mapper) {
		return new UsuariosRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IUsuariosUseCase UsuariosUseCase(IUsuariosRepositorio repositorio) {
		return new UsuariosUseCaseImpl(repositorio);
	}

	@Bean
	IAgenciasRepositorio AgenciasRepositorio(IAgenciasJpaRepositorio jpaRepository, IAgenciasJpaMapper mapper) {
		return new AgenciasRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IAgenciasUseCase AgenciasUseCase(IAgenciasRepositorio repositorio) {
		return new AgenciasUseCaseImpl(repositorio);
	}

	@Bean
	IServiciosExtraRepositorio ServiciosExtraRepositorio(IServiciosExtraJpaRepositorio jpaRepository, IServiciosExtraJpaMapper mapper,
			IReservasJpaRepositorio reservasJpaRepositorio) {
		return new ServiciosExtraRepositorioImpl(jpaRepository, mapper, reservasJpaRepositorio);
	}

	@Bean
	IServiciosExtraUseCase ServiciosExtraUseCase(IServiciosExtraRepositorio repositorio) {
		return new ServiciosExtraUseCaseImpl(repositorio);
	}

	@Bean
	IPaquetesDetallesRepositorio PaquetesDetallesRepositorio(IPaquetesDetallesJpaRepositorio jpaRepository, IPaquetesDetallesJpaMapper mapper) {
		return new PaquetesDetallesRepositorioImpl(jpaRepository, mapper);
	}

	@Bean
	IPaquetesDetallesUseCase PaquetesDetallesUseCase(IPaquetesDetallesRepositorio repositorio) {
		return new PaquetesDetallesUseCaseImpl(repositorio);
	}
}
