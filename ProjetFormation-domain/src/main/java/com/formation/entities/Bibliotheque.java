
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
import javax.persistence.OneToMany;

import com.github.slugify.Slugify;

@Entity
public class Bibliotheque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom, adresse, slug;

	@OneToMany(mappedBy="bibliotheque")
	private List<Rayon> rayons;

	@OneToMany(mappedBy="bibliotheque")
	private List<Inscription> inscriptions;

	public Bibliotheque() {
	}


	public Bibliotheque(String nom, String adresse) {
		this.nom = nom;
		this.adresse = adresse;
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


	public String getSlug() {
		return slug;
	}


	public void setSlug(String slug) {
		this.slug = slug;
	}





}
