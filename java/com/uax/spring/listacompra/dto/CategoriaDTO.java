package com.uax.spring.listacompra.dto;

public class CategoriaDTO {

	private int categoria;
	private String nombre;
	
	public CategoriaDTO() {
		
	}

	public CategoriaDTO(int categoria, String nombre) {
		this.categoria = categoria;
		this.nombre = nombre;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
