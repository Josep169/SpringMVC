package com.atos.ejercicios.dto.request;

public class StockRequest {

	private String nombreT;
	
	private String nombreJ;
	
	private Long stock;

	public String getNombreT() {
		return nombreT;
	}

	public void setNombreT(String nombreT) {
		this.nombreT = nombreT;
	}

	public String getNombreJ() {
		return nombreJ;
	}

	public void setNombreJ(String nombreJ) {
		this.nombreJ = nombreJ;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	
}
