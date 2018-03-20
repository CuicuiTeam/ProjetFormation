package com.formation.dto;

import java.util.Date;

public class EmpruntDTO {
	private int id;
	private Date dateEmprunt;
	private Date dateRetour;
	private int membreId;

	public EmpruntDTO() {
	}

	public EmpruntDTO(Date dateEmprunt, Date dateRetour, int membreId) {
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.membreId = membreId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getMembreId() {
		return membreId;
	}

	public void setMembreId(int membreId) {
		this.membreId = membreId;
	}

}
