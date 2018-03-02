package com.formation.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Livre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// test
	private String titre;
	private String description;
	private double prix;
	private Date datePublication;
	private String imagePath;
	private boolean isPopular;
	private boolean isPeriodic;

	@ManyToMany
	private List<Auteur> auteurs;

	@ManyToOne
	private Editeur editeur;

	@ManyToOne
	private Categorie categorie;

	@OneToMany(mappedBy = "livre")
	private List<Exemplaire> exemplaires;

	@ManyToOne
	private Panier panier;

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public Livre() {

	}

	public Livre(String titre, String description, float prix, Date datePublication, String imagePath,
			boolean isPopular, boolean isPeriodic) {

		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.datePublication = datePublication;
		this.imagePath = imagePath;
		this.isPopular = isPopular;
		this.isPeriodic = isPeriodic;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public boolean isPopular() {
		return isPopular;
	}

	public void setPopular(boolean isPopular) {
		this.isPopular = isPopular;
	}

	public boolean isPeriodic() {
		return isPeriodic;
	}

	public void setPeriodic(boolean isPeriodic) {
		this.isPeriodic = isPeriodic;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

}
