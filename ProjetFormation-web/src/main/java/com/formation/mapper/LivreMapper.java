package com.formation.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formation.dto.LivreDTO;
import com.formation.entities.Livre;

@Component
public class LivreMapper {
	
	@Autowired
	private EditeurMapper editeurMapper;

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
		livreDto.setEditeurDto(editeurMapper.editeurToEditeurDTO(livre.getEditeur()));
		livreDto.setCategorieId(livre.getCategorie().getId());
		List<Integer> auteurId = new ArrayList<>();
		livre.getAuteurs().forEach(a -> auteurId.add(a.getId()));
		livreDto.setAuteursId(auteurId);

		return livreDto;

	}

	public List<LivreDTO> toDTOs(List<Livre> livres) {

		List<LivreDTO> dtos = new ArrayList<LivreDTO>();

		for (Livre unLivre : livres) {
			dtos.add(livreToLivreDTO(unLivre));
		}

		return dtos;

	}

}
