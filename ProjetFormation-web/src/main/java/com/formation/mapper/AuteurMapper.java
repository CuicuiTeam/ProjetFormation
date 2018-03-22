package com.formation.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formation.dto.AuteurDTO;
import com.formation.entities.Auteur;


@Component
public class AuteurMapper {
	
	@Autowired
	private LivreMapper livreMapper;
	
	public AuteurDTO toDTO(Auteur auteur) {
		AuteurDTO auteurDTO = new AuteurDTO(auteur.getNom(), auteur.getPrenom(), auteur.getBiographie(), auteur.getImagePath());
		auteurDTO.setLivres(livreMapper.toDTOs(auteur.getLivres()));
		
		return auteurDTO;
	}
	
	public List<AuteurDTO> toDTOs(List<Auteur> auteurs) {
		List<AuteurDTO> auteursDTO = new ArrayList<>();
		auteurs.forEach(a -> auteursDTO.add(this.toDTO(a)));
		return auteursDTO;
	}
	
	public Auteur toAuteur(AuteurDTO auteurDto) {
		Auteur auteur = new Auteur(auteurDto.getNom(), auteurDto.getPrenom(), auteurDto.getBiographie(), auteurDto.getImagePath());
		auteur.setId(auteurDto.getId());
		auteur.setLivres(livreMapper.toLivres(auteurDto.getLivres()));
		return auteur;
	}
	
	public List<Auteur> toAuteurs(List<AuteurDTO> auteursDTO){
		List<Auteur> auteurs = new ArrayList<>();
		auteursDTO.forEach(a -> auteurs.add(this.toAuteur(a)));
		return auteurs;
	}

}
