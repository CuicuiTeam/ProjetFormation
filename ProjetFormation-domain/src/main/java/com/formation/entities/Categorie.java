package com.formation.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.github.slugify.Slugify;

@Entity
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom, description, slug;

	@OneToMany
	private List<Livre> livres;

	public Categorie() {

	}

	public Categorie(String nom, String description) {
		this.nom = nom;
		this.description = description;
		this.slug = new Slugify().slugify(nom);
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

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}


}