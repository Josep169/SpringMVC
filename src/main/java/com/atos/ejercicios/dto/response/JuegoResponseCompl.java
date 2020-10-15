package com.atos.ejercicios.dto.response;

import java.util.Date;
import java.util.List;

public class JuegoResponseCompl {

	private String titulo;
	private String descripcion;
	private List<GeneroDto> genre;
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
	public List<GeneroDto> getGenre() {
		return genre;
	}
	public void setGenre(List<GeneroDto> genre) {
		this.genre = genre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
