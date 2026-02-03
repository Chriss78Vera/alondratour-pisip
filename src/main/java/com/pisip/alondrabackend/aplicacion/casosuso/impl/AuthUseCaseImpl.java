package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IAuthUseCase;
import com.pisip.alondrabackend.dominio.entidades.Usuarios;
import com.pisip.alondrabackend.dominio.repositorios.IUsuariosRepositorio;
import com.pisip.alondrabackend.presentacion.dto.response.LoginResponseDto;

/**
 * Lógica de autenticación: login por cédula/contraseña, por token, logout y obtener usuario por token.
 * Usa IUsuariosRepositorio para buscar/actualizar usuarios y PasswordEncoder (BCrypt) para validar contraseñas.
 */
public class AuthUseCaseImpl implements IAuthUseCase {

	private final IUsuariosRepositorio usuariosRepositorio;
	private final PasswordEncoder passwordEncoder;

	public AuthUseCaseImpl(IUsuariosRepositorio usuariosRepositorio, PasswordEncoder passwordEncoder) {
		this.usuariosRepositorio = usuariosRepositorio;
		this.passwordEncoder = passwordEncoder;
	}

	/** Valida cédula y contraseña, genera token (1h de validez) y lo guarda en el usuario. Devuelve el token si ok. */
	@Override
	public LoginResponseDto login(String cedula, String password) {
		if (cedula == null || cedula.isBlank()) {
			return LoginResponseDto.error("La cédula es obligatoria");
		}
		if (password == null || password.isBlank()) {
			return LoginResponseDto.error("La contraseña es obligatoria");
		}
		Optional<Usuarios> optUsuario = usuariosRepositorio.buscarPorCedula(cedula.trim());
		if (optUsuario.isEmpty()) {
			return LoginResponseDto.error("Cédula o contraseña incorrectos");
		}
		Usuarios usuario = optUsuario.get();
		String hashAlmacenado = usuario.getPasswordHash();
		if (hashAlmacenado == null || hashAlmacenado.isBlank()) {
			return LoginResponseDto.error("Usuario sin contraseña configurada");
		}
		if (!passwordEncoder.matches(password, hashAlmacenado)) {
			return LoginResponseDto.error("Cédula o contraseña incorrectos");
		}
		// Generar token aleatorio (hash) y fecha exp = ahora + 1h
		String tokenAuth = UUID.randomUUID().toString().replace("-", "");
		LocalDateTime fechaAuthExp = LocalDateTime.now().plusHours(1);
		Usuarios actualizado = new Usuarios(
				usuario.getIdUsuario(),
				usuario.getNombre(),
				usuario.getCedula(),
				usuario.getCorreo(),
				usuario.getRol(),
				usuario.getPasswordHash(),
				tokenAuth,
				fechaAuthExp);
		usuariosRepositorio.guardar(actualizado);
		return LoginResponseDto.ok(usuario.getIdUsuario(), tokenAuth);
	}

	/** Comprueba que el token exista y no esté expirado (fecha_auth_exp > ahora). Devuelve success + token si ok. */
	@Override
	public LoginResponseDto loginConToken(String tokenAuth) {
		if (tokenAuth == null || tokenAuth.isBlank()) {
			return LoginResponseDto.error("El token es obligatorio");
		}
		Optional<Usuarios> optUsuario = usuariosRepositorio.buscarPorTokenAuth(tokenAuth.trim());
		if (optUsuario.isEmpty()) {
			return LoginResponseDto.error("Token inválido o no encontrado");
		}
		Usuarios usuario = optUsuario.get();
		LocalDateTime fechaExp = usuario.getFechaAuthExp();
		if (fechaExp == null) {
			return LoginResponseDto.error("Token sin fecha de expiración");
		}
		if (LocalDateTime.now().isAfter(fechaExp)) {
			return LoginResponseDto.error("Token expirado");
		}
		return LoginResponseDto.ok(usuario.getIdUsuario(), usuario.getTokenAuth());
	}

	/** Busca al usuario por token y borra token y fecha de expiración en BD (cierra sesión). */
	@Override
	public LoginResponseDto logout(String tokenAuth) {
		if (tokenAuth == null || tokenAuth.isBlank()) {
			return LoginResponseDto.error("El token es obligatorio");
		}
		Optional<Usuarios> optUsuario = usuariosRepositorio.buscarPorTokenAuth(tokenAuth.trim());
		if (optUsuario.isEmpty()) {
			return LoginResponseDto.error("Token no encontrado");
		}
		Usuarios usuario = optUsuario.get();
		Usuarios actualizado = new Usuarios(
				usuario.getIdUsuario(),
				usuario.getNombre(),
				usuario.getCedula(),
				usuario.getCorreo(),
				usuario.getRol(),
				usuario.getPasswordHash(),
				null,
				null);
		usuariosRepositorio.guardar(actualizado);
		return LoginResponseDto.logoutOk();
	}

	/** Devuelve el usuario si el token es válido y no expiró; vacío si no existe o expiró. (Para OAuth / datos de sesión.) */
	@Override
	public Optional<Usuarios> obtenerUsuarioPorToken(String tokenAuth) {
		if (tokenAuth == null || tokenAuth.isBlank()) {
			return Optional.empty();
		}
		Optional<Usuarios> optUsuario = usuariosRepositorio.buscarPorTokenAuth(tokenAuth.trim());
		if (optUsuario.isEmpty()) {
			return Optional.empty();
		}
		Usuarios usuario = optUsuario.get();
		LocalDateTime fechaExp = usuario.getFechaAuthExp();
		if (fechaExp == null) {
			return Optional.empty();
		}
		if (LocalDateTime.now().isAfter(fechaExp)) {
			return Optional.empty();
		}
		return Optional.of(usuario);
	}
}
