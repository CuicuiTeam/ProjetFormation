package com.formation.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Emprunt implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Membre membre;
	
	@OneToMany(mappedBy="emprunt")
	private List<Exemplaire> exemplaires;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	
}
