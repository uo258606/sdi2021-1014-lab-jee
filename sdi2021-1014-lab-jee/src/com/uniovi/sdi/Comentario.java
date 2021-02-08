package com.uniovi.sdi;

public class Comentario {

	private String nombre;
	private String comentario;

	public Comentario(String nombre, String comen) {
		this.comentario = comen;
		this.nombre = nombre;
	}
	
	public Comentario() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
