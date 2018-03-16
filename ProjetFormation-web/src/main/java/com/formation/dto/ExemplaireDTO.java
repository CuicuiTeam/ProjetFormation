package com.formation.dto;

public class ExemplaireDTO {
	private int id;
	private int rayonId;
	private int livreId;
	private int membreId;
	private int empruntId;

	public ExemplaireDTO() {
	}

	public ExemplaireDTO(int rayonId, int livreId, int membreId, int empruntId) {
		this.rayonId = rayonId;
		this.livreId = livreId;
		this.membreId = membreId;
		this.empruntId = empruntId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRayonId() {
		return rayonId;
	}

	public void setRayonId(int rayonId) {
		this.rayonId = rayonId;
	}

	public int getLivreId() {
		return livreId;
	}

	public void setLivreId(int livreId) {
		this.livreId = livreId;
	}

	public int getMembreId() {
		return membreId;
	}

	public void setMembreId(int membreId) {
		this.membreId = membreId;
	}

	public int getEmpruntId() {
		return empruntId;
	}

	public void setEmpruntId(int empruntId) {
		this.empruntId = empruntId;
	}
	
}
