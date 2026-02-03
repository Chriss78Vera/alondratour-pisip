package com.pisip.alondrabackend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HotelesRequestDto {
	private int idHotel;
	@NotNull
	private Integer idPaquetesDetalles;
	@NotBlank
	private String nombre;
	@NotNull
	private Float precio;
}
