package com.pisip.alondrabackend.presentacion.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class LoginResponseDto {

	private boolean success;

	private String message;

	@JsonProperty("token")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String token;

	public static LoginResponseDto ok(int idUsuario, String tokenAuth) {
		LoginResponseDto dto = new LoginResponseDto();
		dto.setSuccess(true);
		dto.setMessage("Credenciales correctas");
		dto.setToken(tokenAuth != null ? tokenAuth : String.valueOf(idUsuario));
		return dto;
	}

	public static LoginResponseDto error(String message) {
		LoginResponseDto dto = new LoginResponseDto();
		dto.setSuccess(false);
		dto.setMessage(message != null ? message : "Credenciales incorrectas");
		dto.setToken(null);
		return dto;
	}

	/** Respuesta específica para logout exitoso. */
	public static LoginResponseDto logoutOk() {
		LoginResponseDto dto = new LoginResponseDto();
		dto.setSuccess(true);
		dto.setMessage("Usuario desconectado correctamente");
		dto.setToken(null);
		return dto;
	}
}
