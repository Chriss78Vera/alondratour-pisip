package com.pisip.alondrabackend.presentacion.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IAuthUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.LoginRequestDto;
import com.pisip.alondrabackend.presentacion.dto.request.ValidateTokenRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.LoginResponseDto;
import com.pisip.alondrabackend.presentacion.dto.response.UsuariosResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IUsuariosDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class AuthControlador {

	private final IAuthUseCase authUseCase;
	private final IUsuariosDtoMapper usuariosMapperDto;

	public AuthControlador(IAuthUseCase authUseCase, IUsuariosDtoMapper usuariosMapperDto) {
		this.authUseCase = authUseCase;
		this.usuariosMapperDto = usuariosMapperDto;
	}

	/**
	 * Login con cédula y contraseña. Actualiza el usuario con token_auth y fecha_auth_exp (ahora + 1h).
	 * Retorna { success, message, token } donde token es el token_auth generado.
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto request) {
		LoginResponseDto result = authUseCase.login(request.getCedula(), request.getPassword());
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
	}

	/**
	 * Login con token_auth. Valida que el token exista y que fecha_auth_exp > ahora.
	 * Si está expirado o no existe, retorna 401.
	 */
	@PostMapping("/loginToken")
	public ResponseEntity<LoginResponseDto> loginConToken(@Valid @RequestBody ValidateTokenRequestDto request) {
		LoginResponseDto result = authUseCase.loginConToken(request.getTokenAuth());
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
	}

	/**
	 * Logout: recibe token_auth, busca el usuario y actualiza token_auth y fecha_auth_exp a null.
	 */
	@PostMapping("/logout")
	public ResponseEntity<LoginResponseDto> logout(@Valid @RequestBody ValidateTokenRequestDto request) {
		LoginResponseDto result = authUseCase.logout(request.getTokenAuth());
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
	}

	/**
	 * Obtiene los datos del usuario por token_auth (OAuth). Envía token por query param.
	 * Valida que el token exista y no esté expirado. Retorna idUsuario, nombre, cedula, correo, rol.
	 */
	@GetMapping("/usuario")
	public ResponseEntity<UsuariosResponseDto> obtenerUsuarioPorToken(@RequestParam String tokenAuth) {
		return authUseCase.obtenerUsuarioPorToken(tokenAuth)
				.map(usuariosMapperDto::toResponse)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
}
