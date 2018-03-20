package com.formation.dto;

import java.util.Date;


public class InscriptionDTO {
	private int id;
	private Date dateInscription;
	private int bibliothequeId;;
	private int membreId;
	
	public InscriptionDTO() {
	}

	public InscriptionDTO(Date dateInscription, int bibliothequeId, int membreId) {
		this.dateInscription = dateInscription;
		this.bibliothequeId = bibliothequeId;
		this.membreId = membreId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public int getBibliothequeId() {
		return bibliothequeId;
	}

	public void setBibliothequeId(int bibliothequeId) {
		this.bibliothequeId = bibliothequeId;
	}

	public int getMembreId() {
		return membreId;
	}

	public void setMembreId(int membreId) {
		this.membreId = membreId;
	}
	
	
	
}
