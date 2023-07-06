package com.example.demo.repo.modelo;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Table(name = "video", schema = "public")
@Entity
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_video")
	@SequenceGenerator(name = "seq_video", sequenceName = "seq_video", allocationSize = 1)
	@Column(name = "vdeo_id")
	private Integer id;
	@Column(name = "vdeo_nombre")
	private String nombre;
	@Column(name = "vdeo_descripcion")
	private String descripcion;
	@Column(name = "vdeo_fecha_subida")
	private LocalDateTime fechaSubida;
	@Column(name = "vdeo_duracion")
	private Double duracion;
	@Column(name = "vdeo_resolucion_video_p")
	private Integer resolucionVideoP;
	@Column(name = "vdeo_comentarios")
	private Boolean comentarios;
	@Column(name = "vdeo_usuario")
	private String usuario;
	
	
	
	
	// Gets y sets
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFechaSubida() {
		return fechaSubida;
	}

	public void setFechaSubida(LocalDateTime fechaSubida) {
		this.fechaSubida = fechaSubida;
	}

	public Double getDuracion() {
		return duracion;
	}

	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}

	public Integer getResolucionVideoP() {
		return resolucionVideoP;
	}

	public void setResolucionVideoP(Integer resolucionVideoP) {
		this.resolucionVideoP = resolucionVideoP;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getComentarios() {
		return comentarios;
	}

	public void setComentarios(Boolean comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaSubida="
				+ fechaSubida + ", duracion=" + duracion + ", resolucionVideoP=" + resolucionVideoP + ", comentarios="
				+ comentarios + ", usuario=" + usuario + "]";
	}

	

}
