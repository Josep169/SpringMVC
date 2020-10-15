package com.atos.ejercicios.dto.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import javax.validation.constraints.NotBlank;

import com.atos.ejercicios.enums.GeneroEnum;

public class JuegoRequest {

//	@NotBlank(message = "Title cant be null or empty")
	private String titulo;
	
	private String descripcion;
	
	private List<GeneroEnum> genre = new ArrayList<>();
	
	private Date fecha;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<GeneroEnum> getGenre() {
		return genre;
	}
	public void setGenre(List<GeneroEnum> genre) {
		this.genre = genre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
