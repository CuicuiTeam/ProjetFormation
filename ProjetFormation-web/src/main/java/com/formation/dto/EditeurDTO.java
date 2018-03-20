package com.formation.dto;

public class EditeurDTO {
	
	private int id;
	private String nom;
	private String adresse;
	
	
	
	public EditeurDTO() {
	}
	
	
	public EditeurDTO(String nom, String adresse) {
		this.nom = nom;
		this.adresse = adresse;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	

}
