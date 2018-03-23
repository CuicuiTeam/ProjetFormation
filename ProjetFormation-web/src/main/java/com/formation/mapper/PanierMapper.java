package com.formation.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.formation.dto.PanierDTO;
import com.formation.entities.Livre;
import com.formation.entities.Panier;
import com.formation.service.LivreService;
import com.formation.service.MembreService;

@Component
public class PanierMapper {

	private MembreService membreService;
	private LivreService livreService;

	public PanierDTO toDTO(Panier panier) {

		PanierDTO pDto = new PanierDTO();
		pDto.setDateCreation(panier.getDateCreation());
		pDto.setDateLivraison(panier.getDateLivraison());
		pDto.setId(panier.getId());
		pDto.setMembreId(panier.getMembre().getId());
		List<Integer> livres = new ArrayList<>();
		for (int i = 0; i < panier.getLivres().size(); i++) {
			livres.add(panier.getLivres().get(i).getId());
		}
		pDto.setLivreIds(livres);

		return pDto;
	}

	public Panier toPanier(PanierDTO pDto) throws Exception {

		Panier panier = new Panier();
		panier.setDateCreation(pDto.getDateCreation());
		panier.setDateLivraison(pDto.getDateLivraison());
		panier.setId(pDto.getId());
		panier.setMembre(membreService.get(pDto.getMembreId()));
		List<Livre> livres = new ArrayList<>();
		for (int i = 0; i < pDto.getLivreIds().size(); i++) {
				livres.add(livreService.get(i));
		}
		panier.setLivres(livres);

		return panier;
	}

}
