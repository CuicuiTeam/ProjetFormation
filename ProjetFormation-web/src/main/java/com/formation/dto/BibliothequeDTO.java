package com.formation.dto;

public class BibliothequeDTO {

	private String nom, adresse;
	private int id;

	public BibliothequeDTO() {

	}

	public BibliothequeDTO(String nom, String adresse) {

		this.nom = nom;
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
