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

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPaquetesUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.PaquetesRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.PaquetesResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IPaquetesDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/paquetes")
public class PaquetesControlador {
	private final IPaquetesUseCase paquetesUseCase;
	private final IPaquetesDtoMapper paquetesMapperDto;

	public PaquetesControlador(IPaquetesUseCase paquetesUseCase, IPaquetesDtoMapper paquetesMapperDto) {
		this.paquetesUseCase = paquetesUseCase;
		this.paquetesMapperDto = paquetesMapperDto;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PaquetesResponseDto> listar() {
		return paquetesUseCase.listarTodo().stream().map(paquetesMapperDto::toResponse).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PaquetesResponseDto crear(@Valid @RequestBody PaquetesRequestDto paquetes) {
		return paquetesMapperDto.toResponse(paquetesUseCase.guardar(paquetesMapperDto.toDomain(paquetes)));
	}

	@GetMapping("/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public PaquetesResponseDto buscarPorId(@RequestParam int id) {
		return paquetesMapperDto.toResponse(paquetesUseCase.buscarPorId(id));
	}

	@GetMapping("/buscarPorPais")
	@ResponseStatus(HttpStatus.OK)
	public List<PaquetesResponseDto> paquetesPorPais(@RequestParam String pais) {
		return paquetesUseCase.paquetesPorPais(pais).stream().map(paquetesMapperDto::toResponse).toList();
	}

	@GetMapping("/buscarPorCiudad")
	@ResponseStatus(HttpStatus.OK)
	public List<PaquetesResponseDto> paquetesPorCiudad(@RequestParam String ciudad) {
		return paquetesUseCase.paquetesPorCiudad(ciudad).stream().map(paquetesMapperDto::toResponse).toList();
	}

	@GetMapping("/buscarPorPaisYCiudad")
	@ResponseStatus(HttpStatus.OK)
	public List<PaquetesResponseDto> paquetesPorPaisYCiudad(@RequestParam String pais, @RequestParam String ciudad) {
		return paquetesUseCase.paquetesPorPaisYCiudad(pais, ciudad).stream().map(paquetesMapperDto::toResponse).toList();
	}

	@GetMapping("/buscarPorIdPaquetesDetalles")
	@ResponseStatus(HttpStatus.OK)
	public List<PaquetesResponseDto> paquetesPorIdPaquetesDetalles(@RequestParam int idPaquetesDetalles) {
		return paquetesUseCase.paquetesPorIdPaquetesDetalles(idPaquetesDetalles).stream().map(paquetesMapperDto::toResponse).toList();
	}
}
