package com.formation.dto;

import java.util.Date;
import java.util.List;

public class PanierDTO {
	private int id;
	private Date dateCreation;
	private Date dateLivraison;
	private int membreId;
	private List<Integer> livreIds;
	
	
	public PanierDTO() {
	}


	public PanierDTO(Date dateCreation, Date dateLivraison, int membreId) {
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.membreId = membreId;
	}


	public int getId() {
		return id;
	}

	public List<Integer> getLivreIds() {
		return livreIds;
	}

	public void setLivreIds(List<Integer> livreIds) {
		this.livreIds = livreIds;
	}


	public void setId(int id) {
		this.id = id;
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


	public int getMembreId() {
		return membreId;
	}


	public void setMembreId(int membreId) {
		this.membreId = membreId;
	}
	
	
}
