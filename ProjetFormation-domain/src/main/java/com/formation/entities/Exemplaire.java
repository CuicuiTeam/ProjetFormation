package com.formation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Exemplaire implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Rayon rayon;

	@ManyToOne
	private Livre livre;

	@ManyToOne
	private Membre membre;

	@ManyToOne
	private Emprunt emprunt;

	public Exemplaire() {
	}

	public Exemplaire(Rayon rayon, Livre livre, Membre membre, Emprunt emprunt) {
		this.rayon = rayon;
		this.livre = livre;
		this.membre = membre;
		this.emprunt = emprunt;
	}
	
	public Exemplaire(Rayon rayon, Livre livre) {
		this.rayon = rayon;
		this.livre = livre;
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}

	public int getId() {
		return id;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Emprunt getEmprunt() {
		return emprunt;
	}

	public void setEmprunt(Emprunt emprunt) {
		this.emprunt = emprunt;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
