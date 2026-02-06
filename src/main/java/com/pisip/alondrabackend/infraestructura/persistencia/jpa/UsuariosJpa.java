package com.pisip.alondrabackend.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuario")
public class UsuariosJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false, unique = true)
	private String cedula;

	@Column(nullable = false, unique = true)
	private String correo;

	@Column(nullable = false)
	private String rol;

	@Column(name = "password_hash", nullable = true, length = 255)
	private String passwordHash;

	@Column(name = "token_auth", nullable = true, length = 255)
	private String tokenAuth;

	@Column(name = "fecha_auth_exp", nullable = true)
	private LocalDateTime fechaAuthExp;

	@Column(nullable = false)
	private boolean estado = true;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ReservasJpa> reservas;

}
