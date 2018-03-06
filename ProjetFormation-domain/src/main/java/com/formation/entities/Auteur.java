package com.formation.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.github.slugify.Slugify;

@Entity
public class Auteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom, prenom, slug;

	@ManyToMany
	@JoinTable(name = "livre_auteur", joinColumns = { @JoinColumn(name = "auteur_id") }, inverseJoinColumns = { @JoinColumn(name = "livre_id") })
	private List<Livre> livres;

	public Auteur() {

	}

	public Auteur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.slug = new Slugify().slugify(this.prenom +" "+ this.nom);
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
