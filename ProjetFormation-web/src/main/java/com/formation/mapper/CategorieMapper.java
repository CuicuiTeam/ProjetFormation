package com.formation.mapper;

import org.springframework.stereotype.Component;

import com.formation.dto.CategorieDTO;
import com.formation.entities.Categorie;

@Component
public class CategorieMapper {

	public CategorieDTO categorieTOCategorieDTO(Categorie categorie) {
		CategorieDTO categorieDto = new CategorieDTO();
		categorieDto.setId(categorie.getId());
		categorieDto.setDescription(categorie.getDescription());
		categorieDto.setNom(categorie.getNom());
		
		return categorieDto;
		
	}
	
	public Categorie categorieDtoToCategorie(CategorieDTO categorieDto) {
		Categorie categorie = new Categorie();
		categorie.setId(categorieDto.getId());
		categorie.setDescription(categorie.getDescription());
		categorie.setNom(categorie.getNom());
		
		return categorie;
	}
}
