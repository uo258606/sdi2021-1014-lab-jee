package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {

	@Id
	@GeneratedValue
	Long ID;
	String dni;
	String name;
	String surname;
	String categoria;
	
	public Professor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Professor [id=" + ID + ", nif=" + dni + ", name=" + name + ", surname=" + surname + ", categoria=" + categoria + "]";
	}

	public Professor(String nif, String name, String surname, String categoria) {
		super();
		this.dni = nif;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String nif) {
		this.dni = nif;
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
