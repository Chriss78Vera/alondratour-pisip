package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Usuarios;
import com.pisip.alondrabackend.presentacion.dto.response.LoginResponseDto;

public interface IAuthUseCase {

	/**
	 * Valida cédula (usuario) y contraseña contra la BD.
	 * Actualiza el usuario con token_auth (hash aleatorio) y fecha_auth_exp (ahora + 1h).
	 * Retorna el token_auth en la respuesta.
	 */
	LoginResponseDto login(String cedula, String password);

	/**
	 * Valida token_auth: debe existir el usuario con ese token y fecha_auth_exp > ahora.
	 * Si está expirado o no existe, retorna error.
	 */
	LoginResponseDto loginConToken(String tokenAuth);

	/**
	 * Logout: busca el usuario por token_auth y actualiza token_auth y fecha_auth_exp a null.
	 */
	LoginResponseDto logout(String tokenAuth);

	/**
	 * Obtiene el usuario por token_auth. Valida que el token exista y que fecha_auth_exp > ahora.
	 * Empty si token inválido o expirado.
	 */
	Optional<Usuarios> obtenerUsuarioPorToken(String tokenAuth);
}
