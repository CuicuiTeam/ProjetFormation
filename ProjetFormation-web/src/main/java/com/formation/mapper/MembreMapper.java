package com.formation.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.formation.dto.MembreDTO;
import com.formation.entities.Inscription;
import com.formation.entities.Membre;

@Component
public class MembreMapper {

	public MembreDTO toDto(Membre membre) {
		MembreDTO membreDTO = new MembreDTO();

		membreDTO.setAdmin(membre.isAdmin());
		membreDTO.setAdresse(membre.getAdresse());
		membreDTO.setCodePostal(membre.getCodePostal());
		membreDTO.setEmail(membre.getEmail());
		membreDTO.setId(membre.getId());
		List<Integer> ids = new ArrayList<Integer>();
//		for (Inscription inscription : membre.getInscriptions()) {
//
//			ids.add(inscription.getId());
//
//		}
//		membreDTO.setInscriptionsId(ids);
		membreDTO.setNom(membre.getNom());
		membreDTO.setPrenom(membre.getPrenom());
		membreDTO.setTelephone(membre.getTelephone());
		membreDTO.setVille(membre.getVille());

		return membreDTO;
	}

	public List<MembreDTO> toDtos(List<Membre> membres) {

		List<MembreDTO> membreDTOs = new ArrayList<MembreDTO>();
		for (Membre membre : membres) {
			membreDTOs.add(toDto(membre));
		}

		return membreDTOs;
	}

	public Membre toMembre(MembreDTO membreDTO) {
		Membre membre = new Membre();
		membre.setAdmin(membreDTO.isAdmin());
		membre.setAdresse(membreDTO.getAdresse());
		membre.setCodePostal(membreDTO.getCodePostal());
		membre.setEmail(membreDTO.getEmail());
		membre.setId(membreDTO.getId());
		// TODO: Recuperer de la bd
		// membre.setInscriptions(inscriptions);
		membre.setNom(membreDTO.getNom());
		membre.setPrenom(membreDTO.getPrenom());
		membre.setTelephone(membreDTO.getTelephone());

		membre.setVille(membreDTO.getVille());

		return membre;
	}

}
