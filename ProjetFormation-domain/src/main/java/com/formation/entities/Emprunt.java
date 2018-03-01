package com.formation.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Emprunt implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Membre membre;
	
	private Date dateEmprunt, dateRetour;
	
	public Emprunt() {
	}

	public Emprunt(Membre membre, Date dateEmprunt, Date dateRetour) {
		this.membre = membre;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Date getDate_emprunt() {
		return dateEmprunt;
	}

	public void setDate_emprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDate_retour() {
		return dateRetour;
	}

	public void setDate_retour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

}
