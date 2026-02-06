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

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IHotelesUseCase;
import com.pisip.alondrabackend.dominio.entidades.Hoteles;
import com.pisip.alondrabackend.presentacion.dto.request.HotelesRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.HotelesResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IHotelesDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/hoteles")
public class HotelesControlador {
	private final IHotelesUseCase hotelesUseCase;
	private final IHotelesDtoMapper hotelesMapperDto;

	public HotelesControlador(IHotelesUseCase hotelesUseCase, IHotelesDtoMapper hotelesMapperDto) {
		this.hotelesUseCase = hotelesUseCase;
		this.hotelesMapperDto = hotelesMapperDto;
	}

	@GetMapping
	public List<HotelesResponseDto> listar() {
		return hotelesUseCase.listarTodo().stream().map(hotelesMapperDto::toResponse).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HotelesResponseDto crear(@Valid @RequestBody HotelesRequestDto hoteles) {
		return hotelesMapperDto.toResponse(hotelesUseCase.guardar(hotelesMapperDto.toDomain(hoteles)));
	}

	@PostMapping("/editar")
	@ResponseStatus(HttpStatus.OK)
	public HotelesResponseDto editar(@Valid @RequestBody HotelesRequestDto dto) {
		return hotelesMapperDto.toResponse(hotelesUseCase.guardar(hotelesMapperDto.toDomain(dto)));
	}

	@GetMapping("/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public HotelesResponseDto buscarPorId(@RequestParam int id) {
		return hotelesMapperDto.toResponse(hotelesUseCase.buscarPorId(id));
	}

	@GetMapping("/buscarPorNombre")
	@ResponseStatus(HttpStatus.OK)
	public List<HotelesResponseDto> hotelesPorNombre(@RequestParam String nombre) {
		return hotelesUseCase.hotelesPorNombre(nombre).stream()
				.filter(Hoteles::isEstado)
				.map(hotelesMapperDto::toResponse).toList();
	}

	@GetMapping("/buscarPorIdPaquetesDetalles")
	@ResponseStatus(HttpStatus.OK)
	public List<HotelesResponseDto> hotelesPorIdPaquetesDetalles(@RequestParam int idPaquetesDetalles) {
		return hotelesUseCase.hotelesPorIdPaquetesDetalles(idPaquetesDetalles).stream()
				.filter(Hoteles::isEstado)
				.map(hotelesMapperDto::toResponse).toList();
	}
}
