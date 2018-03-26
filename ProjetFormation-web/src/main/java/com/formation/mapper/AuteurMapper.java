package com.formation.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.formation.dto.AuteurDTO;
import com.formation.entities.Auteur;


@Component
public class AuteurMapper {
	
	
	public AuteurDTO toDTO(Auteur auteur) {
		AuteurDTO auteurDTO = new AuteurDTO(auteur.getNom(), auteur.getPrenom(), auteur.getBiographie(), auteur.getImagePath());
		
		return auteurDTO;
	}
	
	public List<AuteurDTO> toDTOs(List<Auteur> auteurs) {
		List<AuteurDTO> auteursDTO = new ArrayList<>();
		auteurs.forEach(a -> auteursDTO.add(this.toDTO(a)));
		return auteursDTO;
	}
	
	
	

}
