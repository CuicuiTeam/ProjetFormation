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
	
	public EditeurDTO toDTOs(Editeur editeur) {
		EditeurDTO dtos = new EditeurDTO();
//		dtos.add(editeurToEditeurDTO(editeur));
		
		return dtos;
	}

}
