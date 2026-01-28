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

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IHotelesReservasUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.HotelesReservasRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.HotelesReservasResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IHotelesReservasDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/hoteles-reservas")
public class HotelesReservasControlador {
	private final IHotelesReservasUseCase hotelesReservasUseCase;
	private final IHotelesReservasDtoMapper hotelesReservasMapperDto;

	public HotelesReservasControlador(IHotelesReservasUseCase hotelesReservasUseCase,
			IHotelesReservasDtoMapper hotelesReservasMapperDto) {
		this.hotelesReservasUseCase = hotelesReservasUseCase;
		this.hotelesReservasMapperDto = hotelesReservasMapperDto;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<HotelesReservasResponseDto> listar() {
		return hotelesReservasUseCase.listarTodo().stream().map(hotelesReservasMapperDto::toResponse).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HotelesReservasResponseDto crear(@Valid @RequestBody HotelesReservasRequestDto hotelesReservas) {
		return hotelesReservasMapperDto.toResponse(
				hotelesReservasUseCase.guardar(hotelesReservasMapperDto.toDomain(hotelesReservas)));
	}

	@GetMapping("/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public HotelesReservasResponseDto buscarPorId(@RequestParam int id) {
		return hotelesReservasMapperDto.toResponse(hotelesReservasUseCase.buscarPorId(id));
	}

	@GetMapping("/buscarPorIdReserva")
	@ResponseStatus(HttpStatus.OK)
	public List<HotelesReservasResponseDto> hotelesReservasPorIdReserva(@RequestParam int idReserva) {
		return hotelesReservasUseCase.hotelesReservasPorIdReserva(idReserva).stream()
				.map(hotelesReservasMapperDto::toResponse).toList();
	}

	@GetMapping("/buscarPorIdHotel")
	@ResponseStatus(HttpStatus.OK)
	public List<HotelesReservasResponseDto> hotelesReservasPorIdHotel(@RequestParam int idHotel) {
		return hotelesReservasUseCase.hotelesReservasPorIdHotel(idHotel).stream()
				.map(hotelesReservasMapperDto::toResponse).toList();
	}
}
