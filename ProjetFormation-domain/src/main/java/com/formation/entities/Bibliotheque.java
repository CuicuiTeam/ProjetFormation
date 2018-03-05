package com.formation.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Bibliotheque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;

	@OneToMany(mappedBy="bibliotheque")
	private List<Rayon> rayons;

	@ManyToMany
	private List<Membre> membres;

	@OneToMany(mappedBy="bibliotheque")
	private List<Inscription> inscriptions;

	public Bibliotheque() {
	}


	public Bibliotheque(String nom, String adresse) {
		this.nom = nom;
		this.adresse = adresse;
	}


	public int getId() {
		return id;
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


	public List<Rayon> getRayons() {
		return rayons;
	}


	public void setRayons(List<Rayon> rayons) {
		this.rayons = rayons;
	}





}
