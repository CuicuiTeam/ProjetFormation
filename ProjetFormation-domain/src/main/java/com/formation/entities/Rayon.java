package com.formation.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.github.slugify.Slugify;

@Entity
public class Rayon implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String description;
	private int nbrLivres;
	


	private String slug;
	
	@OneToMany(mappedBy="rayon")
	private List<Exemplaire> exemplaires;
	
	@ManyToOne
	private Bibliotheque bibliotheque;
	
	
	public Rayon() {
	}


	public Rayon(String nom, String description, int nbrLivres) {
		this.nom = nom;
		this.description = description;
		this.nbrLivres = nbrLivres;
		this.slug = new Slugify().slugify(nom);
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


	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}


	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}


	public Bibliotheque getBibliotheque() {
		return bibliotheque;
	}


	public void setBibliotheque(Bibliotheque bibliotheque) {
		this.bibliotheque = bibliotheque;
	}

	public String getSlug() {
		return slug;
	}


	public void setSlug(String slug) {
		this.slug = slug;
	}

	public void setId(int id) {
		this.id = id;
	}

}
