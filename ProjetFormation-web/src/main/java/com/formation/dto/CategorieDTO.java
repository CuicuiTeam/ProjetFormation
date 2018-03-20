package com.formation.dto;

import java.util.List;

import javax.persistence.OneToMany;

import com.formation.entities.Livre;

public class CategorieDTO {

	private int id;
	private String nom;
	private String description;
	

	public CategorieDTO(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}

	public CategorieDTO() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
