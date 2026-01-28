package com.pisip.alondrabackend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IHotelesUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPaquetesDetallesUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPaquetesUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.PaquetesRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.PaqueteCompletoResponseDto;
import com.pisip.alondrabackend.presentacion.dto.response.PaisesYCiudadesDistintosResponseDto;
import com.pisip.alondrabackend.presentacion.dto.response.PaqueteDetallesConHotelesResponseDto;
import com.pisip.alondrabackend.presentacion.dto.response.PaquetesResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IHotelesDtoMapper;
import com.pisip.alondrabackend.presentacion.mapeadores.IPaquetesDetallesDtoMapper;
import com.pisip.alondrabackend.presentacion.mapeadores.IPaquetesDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/paquetes")
public class PaquetesControlador {
	private final IPaquetesUseCase paquetesUseCase;
	private final IPaquetesDtoMapper paquetesMapperDto;
	private final IPaquetesDetallesUseCase paquetesDetallesUseCase;
	private final IPaquetesDetallesDtoMapper paquetesDetallesMapperDto;
	private final IHotelesUseCase hotelesUseCase;
	private final IHotelesDtoMapper hotelesMapperDto;

	public PaquetesControlador(IPaquetesUseCase paquetesUseCase, IPaquetesDtoMapper paquetesMapperDto,
			IPaquetesDetallesUseCase paquetesDetallesUseCase, IPaquetesDetallesDtoMapper paquetesDetallesMapperDto,
			IHotelesUseCase hotelesUseCase, IHotelesDtoMapper hotelesMapperDto) {
		this.paquetesUseCase = paquetesUseCase;
		this.paquetesMapperDto = paquetesMapperDto;
		this.paquetesDetallesUseCase = paquetesDetallesUseCase;
		this.paquetesDetallesMapperDto = paquetesDetallesMapperDto;
		this.hotelesUseCase = hotelesUseCase;
		this.hotelesMapperDto = hotelesMapperDto;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PaqueteCompletoResponseDto> listar() {
		return paquetesUseCase.listarTodo().stream().map(paquete -> {
			var base = paquetesMapperDto.toResponse(paquete);
			var detalle = paquetesDetallesUseCase.buscarPorId(paquete.getIdPaquetesDetalles());
			var hoteles = hotelesUseCase.hotelesPorIdPaquetesDetalles(paquete.getIdPaquetesDetalles());
			var hotelesDto = hoteles.stream().map(hotelesMapperDto::toResponse).toList();
			return new PaqueteCompletoResponseDto(
					base.getIdPaquete(),
					base.getIdPaquetesDetalles(),
					base.getNombre(),
					base.getDescripcion(),
					base.getPais(),
					base.getCiudad(),
					paquetesDetallesMapperDto.toResponse(detalle),
					hotelesDto);
		}).toList();
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

	@GetMapping("/paisesYCiudadesDistintos")
	@ResponseStatus(HttpStatus.OK)
	public PaisesYCiudadesDistintosResponseDto paisesYCiudadesDistintos() {
		var paises = paquetesUseCase.paisesDistintos();
		var ciudades = paquetesUseCase.ciudadesDistintas();
		return new PaisesYCiudadesDistintosResponseDto(paises, ciudades);
	}

	@GetMapping("/detallesConHoteles")
	@ResponseStatus(HttpStatus.OK)
	public PaqueteDetallesConHotelesResponseDto detallesConHotelesPorIdPaquete(@RequestParam int idPaquete) {
		var paquete = paquetesUseCase.buscarPorId(idPaquete);
		int idPaquetesDetalles = paquete.getIdPaquetesDetalles();
		var hoteles = hotelesUseCase.hotelesPorIdPaquetesDetalles(idPaquetesDetalles);
		var hotelesDto = hoteles.stream().map(hotelesMapperDto::toResponse).toList();
		return new PaqueteDetallesConHotelesResponseDto(idPaquetesDetalles, hotelesDto);
	}

	@GetMapping("/detallesConHotelesPorPaqueteYDetalle")
	@ResponseStatus(HttpStatus.OK)
	public PaqueteDetallesConHotelesResponseDto detallesConHotelesPorIdPaqueteYDetalle(
			@RequestParam int idPaquete,
			@RequestParam int idPaquetesDetalles) {
		var paquetesConEsteDetalle = paquetesUseCase.paquetesPorIdPaquetesDetalles(idPaquetesDetalles);
		boolean pertenece = paquetesConEsteDetalle.stream().anyMatch(p -> p.getIdPaquete() == idPaquete);
		if (!pertenece) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"El detalle " + idPaquetesDetalles + " no pertenece al paquete " + idPaquete);
		}
		var hoteles = hotelesUseCase.hotelesPorIdPaquetesDetalles(idPaquetesDetalles);
		var hotelesDto = hoteles.stream().map(hotelesMapperDto::toResponse).toList();
		return new PaqueteDetallesConHotelesResponseDto(idPaquetesDetalles, hotelesDto);
	}
}
