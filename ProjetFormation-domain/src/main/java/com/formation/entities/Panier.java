package com.formation.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Panier implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Date dateCreation, dateLivraison;
	
	@ManyToOne
	private Membre membre;
	
	@ManyToMany(mappedBy = "panier")
	private List<Livre> livres;

	public Panier() {
	}

	public Panier(Date dateCreation, Date dateLivraison) {
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public int getId() {
		return id;
	}
	
	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public List<Livre> getLivres() {
		if (livres == null) {
			return new ArrayList<Livre>();
		}
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
