package com.pisip.alondrabackend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IUsuariosUseCase;
import com.pisip.alondrabackend.dominio.entidades.Usuarios;
import com.pisip.alondrabackend.presentacion.dto.request.UsuariosRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.UsuariosResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IUsuariosDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosControlador {
	private final IUsuariosUseCase usuariosUseCase;
	private final IUsuariosDtoMapper usuariosMapperDto;
	private final PasswordEncoder passwordEncoder;

	public UsuariosControlador(IUsuariosUseCase usuariosUseCase, IUsuariosDtoMapper usuariosMapperDto,
			PasswordEncoder passwordEncoder) {
		this.usuariosUseCase = usuariosUseCase;
		this.usuariosMapperDto = usuariosMapperDto;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UsuariosResponseDto> listar() {
		return usuariosUseCase.listarTodo().stream().map(usuariosMapperDto::toResponse).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuariosResponseDto crear(@Valid @RequestBody UsuariosRequestDto dto) {
		if (dto.getPassword() == null || dto.getPassword().isBlank()) {
			throw new IllegalArgumentException("La contraseña es obligatoria para crear usuario");
		}
		String passwordHash = passwordEncoder.encode(dto.getPassword());
		Usuarios usuario = new Usuarios(0, dto.getNombre(), dto.getCedula(), dto.getCorreo(), dto.getIdRol(), null, passwordHash, null, null, dto.isEstado());
		return usuariosMapperDto.toResponse(usuariosUseCase.guardar(usuario));
	}

	@PostMapping("/actualizar")
	@ResponseStatus(HttpStatus.OK)
	public UsuariosResponseDto actualizar(@Valid @RequestBody UsuariosRequestDto dto) {
		Usuarios actual = usuariosUseCase.buscarPorId(dto.getIdUsuario());
		String passwordHash = dto.getPassword() != null && !dto.getPassword().isBlank()
				? passwordEncoder.encode(dto.getPassword())
				: actual.getPasswordHash();
		Usuarios actualizado = new Usuarios(
				dto.getIdUsuario(),
				dto.getNombre(),
				dto.getCedula(),
				dto.getCorreo(),
				dto.getIdRol(),
				actual.getTipoRol(),
				passwordHash,
				actual.getTokenAuth(),
				actual.getFechaAuthExp(),
				dto.isEstado());
		return usuariosMapperDto.toResponse(usuariosUseCase.guardar(actualizado));
	}

	@GetMapping("/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public UsuariosResponseDto buscarPorId(@RequestParam int id) {
		return usuariosMapperDto.toResponse(usuariosUseCase.buscarPorId(id));
	}

	@GetMapping("/buscarPorCedula")
	@ResponseStatus(HttpStatus.OK)
	public UsuariosResponseDto buscarPorCedula(@RequestParam String cedula) {
		return usuariosMapperDto.toResponse(usuariosUseCase.buscarPorCedula(cedula));
	}

	@GetMapping("/buscarPorCorreo")
	@ResponseStatus(HttpStatus.OK)
	public UsuariosResponseDto buscarPorCorreo(@RequestParam String correo) {
		return usuariosMapperDto.toResponse(usuariosUseCase.buscarPorCorreo(correo));
	}

	@GetMapping("/buscarPorRol")
	@ResponseStatus(HttpStatus.OK)
	public List<UsuariosResponseDto> listarPorRol(@RequestParam String rol) {
		return usuariosUseCase.listarPorRol(rol).stream().map(usuariosMapperDto::toResponse).toList();
	}
}
