package com.uniovi.entities;



public class Professor {

	
	Long ID;
	String nif;
	String name;
	String surname;
	String categoria;
	
	public Professor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Professor [id=" + ID + ", nif=" + nif + ", name=" + name + ", surname=" + surname + ", categoria=" + categoria + "]";
	}

	public Professor(Long id, String nif, String name, String surname, String categoria) {
		super();
		this.ID = id;
		this.nif = nif;
		this.name = name;
		this.surname = surname;
		this.categoria = categoria;
	}



	public Long getId() {
		return ID;
	}

	public void setId(Long iD) {
		ID = iD;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	 
	
}
