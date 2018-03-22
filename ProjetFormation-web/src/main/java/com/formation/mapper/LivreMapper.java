package com.formation.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formation.dto.AuteurDTO;
import com.formation.dto.LivreDTO;
import com.formation.entities.Livre;

@Component
public class LivreMapper {
	
	@Autowired
	private AuteurMapper auteurMapper;

	public LivreDTO livreToLivreDTO(Livre livre) {
		LivreDTO livreDto = new LivreDTO();
		livreDto.setId(livre.getId());
		livreDto.setTitre(livre.getTitre());
		livreDto.setDescription(livre.getDescription());
		livreDto.setPrix(livre.getPrix());
		livreDto.setDatePublication(livre.getDatePublication());
		livreDto.setImagePath(livre.getImagePath());
		livreDto.setPopular(livre.isPopular());
		livreDto.setPeriodic(livre.isPeriodic());
		livreDto.setEditeurId(livre.getEditeur().getId());
		livreDto.setCategorieId(livre.getCategorie().getId());
		List<AuteurDTO> auteurs = new ArrayList<>();
		livre.getAuteurs().forEach(a -> auteurs.add(auteurMapper.toDTO(a)));

		return livreDto;

	}
	
	public Livre toLivre(LivreDTO livreDto) {
		Livre livre = new Livre(livreDto.getTitre(), livreDto.getDescription(), livreDto.getPrix(), livreDto.getDatePublication(), livreDto.getImagePath(), livreDto.isPopular(), livreDto.isPeriodic());
		livre.setId(livreDto.getId());
		livre.setAuteurs(auteurMapper.toAuteurs(livreDto.getAuteurs()));
		return livre;
	}

	public List<LivreDTO> toDTOs(List<Livre> livres) {

		List<LivreDTO> dtos = new ArrayList<LivreDTO>();

		for (Livre unLivre : livres) {
			dtos.add(livreToLivreDTO(unLivre));
		}

		return dtos;

	}
	
	public List<Livre> toLivres(List<LivreDTO> livresDTO){
		List<Livre> livres = new ArrayList<>();
		livresDTO.forEach(l -> livres.add(this.toLivre(l)));
		return livres;
	}

}
