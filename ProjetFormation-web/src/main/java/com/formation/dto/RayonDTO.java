package com.formation.dto;

import java.util.List;

public class RayonDTO {

	private int id;
	private String nom;
	private String description;
	private int nbrLivres;
	private List<Integer> exemplairesId;
	private int bibliothequeId;

	public RayonDTO() {

	}

	public RayonDTO(String nom, String description, int nbrLivres, int bibliothequeId) {
		super();
		this.nom = nom;
		this.description = description;
		this.nbrLivres = nbrLivres;
		this.exemplairesId = exemplairesId;
		this.bibliothequeId = bibliothequeId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbrLivres() {
		return nbrLivres;
	}

	public void setNbrLivres(int nbrLivres) {
		this.nbrLivres = nbrLivres;
	}

	public List<Integer> getExemplairesId() {
		return exemplairesId;
	}

	public void setExemplairesId(List<Integer> exemlplairesId) {
		this.exemplairesId = exemlplairesId;
	}

	public int getBibliothequeId() {
		return bibliothequeId;
	}

	public void setBibliothequeId(int bibliothequeId) {
		this.bibliothequeId = bibliothequeId;
	}

}
