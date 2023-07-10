package com.example.demo.repo.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Table(name = "creador_contenido")
@Entity
public class CreadorContenido {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_creador_contenido")
	@SequenceGenerator(name = "seq_creador_contenido", sequenceName = "seq_creador_contenido", allocationSize = 1)
	@Column(name = "crco_id")
	private Integer id;
	@Column(name = "crco_email")
	private String email;
	@Column(name = "crco_nombre_usuario")
	private String nombreUsuario;
	@Column(name = "crco_nombre")
	private String nombre;
	@Column(name = "crco_apellido")
	private String apellido;
	@Column(name = "crco_celular")
	private String celular;
	@Column(name = "crco_fecha_nacimiento")
	private LocalDate fechaNacimiento;
	@Column(name = "crco_fecha_creaecion_cuenta")
	private LocalDateTime fechaCreacionCuenta;

	@OneToMany(mappedBy = "creadorContenido")
	private List<Video> video;

	
	//Get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDateTime getFechaCreacionCuenta() {
		return fechaCreacionCuenta;
	}

	public void setFechaCreacionCuenta(LocalDateTime fechaCreacionCuenta) {
		this.fechaCreacionCuenta = fechaCreacionCuenta;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	
	@Override
	public String toString() {
		return "CreadorContenido [id=" + id + ", email=" + email + ", nombreUsuario=" + nombreUsuario + ", nombre="
				+ nombre + ", apellido=" + apellido + ", celular=" + celular + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaCreacionCuenta=" + fechaCreacionCuenta + "]";
	}

}
