package com.formation.dto;

import java.sql.Date;
import java.util.List;

import com.formation.entities.Editeur;

public class LivreDTO {
	private String titre;
	private String description;
	private double prix;
	private Date datePublication;
	private String imagePath;
	private boolean isPopular;
	private boolean isPeriodic;
	private EditeurDTO editeurDto;
	private int categorieId;
	private List<AuteurDTO> auteurs;
	private int id;

	public LivreDTO() {
		// TODO Auto-generated constructor stub
	}

	public LivreDTO(String titre, String description, double prix, Date datePublication, String imagePath,
			boolean isPopular, boolean isPeriodic, EditeurDTO editeurDto, int categorieId) {
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.datePublication = datePublication;
		this.imagePath = imagePath;
		this.isPopular = isPopular;
		this.isPeriodic = isPeriodic;
		this.editeurDto = editeurDto;
		this.categorieId = categorieId;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
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

	

	public int getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
	}

	public List<AuteurDTO> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<AuteurDTO> auteurs) {
		this.auteurs = auteurs;
	}

	public EditeurDTO getEditeurDto() {
		return editeurDto;
	}

	public void setEditeurDto(EditeurDTO editeurDto) {
		this.editeurDto = editeurDto;
	}

}
