package com.formation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Auteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom, prenom;
	@Type(type="text")
	private String biographie;

//	@ManyToMany(mappedBy="auteurs")
//	private List<Livre> livres;
	
	private String imagePath;

	public Auteur() {

	}

	public Auteur(String nom, String prenom, String biographie, String imagePath) {
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

//	public List<Livre> getLivres() {
//		return livres;
//	}
//
//	public void setLivres(List<Livre> livres) {
//		this.livres = livres;
//	}

	public int getId() {
		return id;
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
	
}
