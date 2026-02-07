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

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IRolUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.RolRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.RolResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IRolDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/roles")
public class RolControlador {
	private final IRolUseCase rolUseCase;
	private final IRolDtoMapper rolMapperDto;

	public RolControlador(IRolUseCase rolUseCase, IRolDtoMapper rolMapperDto) {
		this.rolUseCase = rolUseCase;
		this.rolMapperDto = rolMapperDto;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<RolResponseDto> listar() {
		return rolUseCase.listarTodo().stream().map(rolMapperDto::toResponse).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RolResponseDto crear(@Valid @RequestBody RolRequestDto dto) {
		return rolMapperDto.toResponse(rolUseCase.guardar(rolMapperDto.toDomain(dto)));
	}

	@GetMapping("/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public RolResponseDto buscarPorId(@RequestParam int id) {
		return rolMapperDto.toResponse(rolUseCase.buscarPorId(id));
	}

	@GetMapping("/buscarPorTipo")
	@ResponseStatus(HttpStatus.OK)
	public RolResponseDto buscarPorTipo(@RequestParam String tipo) {
		return rolMapperDto.toResponse(rolUseCase.buscarPorTipo(tipo));
	}
}
