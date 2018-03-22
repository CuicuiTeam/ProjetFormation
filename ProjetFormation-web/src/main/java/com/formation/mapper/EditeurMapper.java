package com.formation.mapper;

import org.springframework.stereotype.Component;

import com.formation.dto.EditeurDTO;
import com.formation.entities.Editeur;

@Component
public class EditeurMapper {
	
	public EditeurDTO editeurToEditeurDTO(Editeur editeur) {
		EditeurDTO editeurDto = new EditeurDTO();
		editeurDto.setId(editeur.getId());
		editeurDto.setAdresse(editeur.getAdresse());
		editeurDto.setNom(editeur.getNom());
		
		return editeurDto;
		
	}
	
	public Editeur editeurDtoTOEditeur(EditeurDTO editeurDto) {
		Editeur editeur = new Editeur();
		editeur.setAdresse(editeurDto.getAdresse());
		editeur.setId(editeurDto.getId());
		editeur.setNom(editeurDto.getNom());
		return editeur;
	}

}
