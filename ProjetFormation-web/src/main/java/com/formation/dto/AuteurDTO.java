package com.formation.dto;

import java.util.List;

public class AuteurDTO {
	private int id;
	private String nom;
	private String prenom;
	private String biographie;
	private String imagePath;
	private List<LivreDTO> livres;
	
	public AuteurDTO() {
	}

	public AuteurDTO(String nom, String prenom, String biographie, String imagePath) {
		this.nom = nom;
		this.prenom = prenom;
		this.biographie = biographie;
		this.imagePath = imagePath;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getBiographie() {
		return biographie;
	}

	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<LivreDTO> getLivres() {
		return livres;
	}

	public void setLivres(List<LivreDTO> livres) {
		this.livres = livres;
	}

	
	
}
