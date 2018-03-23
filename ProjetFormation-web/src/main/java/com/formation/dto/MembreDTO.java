package com.formation.dto;

import java.util.List;


public class MembreDTO {
	
	private List<Integer> inscriptionsId;
	private int id;
	private String nom;
	private String prenom;
	private String password;
	private String adresse;
	private String ville;
	private String codePostal;
	private String telephone;
	private String email;
	private boolean isAdmin;
	
	
	public MembreDTO() {
	}


	public MembreDTO( String nom, String prenom, String password, String adresse,
			String ville, String codePostal, String telephone, String email, boolean isAdmin) {
//		this.inscriptionsId = inscriptionsId;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.telephone = telephone;
		this.email = email;
		this.isAdmin = isAdmin;
	}


	public List<Integer> getInscriptionsId() {
		return inscriptionsId;
	}


	public void setInscriptionsId(List<Integer> inscriptionsId) {
		this.inscriptionsId = inscriptionsId;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	

	// @Override
	// public String toString() {
	// return "MembreDTO [inscriptionsId=" + inscriptionsId + ", bibliothequesId=" +
	// bibliothequesId + ", id=" + id
	// + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ",
	// adresse=" + adresse + ", ville="
	// + ville + ", codePostal=" + codePostal + ", telephone=" + telephone + ",
	// email=" + email + ", isAdmin="
	// + isAdmin + "]";
	// }
	//
	
	
}
