package com.formation.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.formation.dto.LivreDTO;
import com.formation.dto.PanierDTO;
import com.formation.entities.Livre;
import com.formation.entities.Panier;
import com.formation.service.LivreService;
import com.formation.service.MembreService;

@Component
public class PanierMapper {

	@Autowired
	private MembreService membreService;

	@Autowired
	private LivreService livreService;

	@Autowired
	LivreMapper livreMapper;

	public PanierDTO toDTO(Panier panier) {

		PanierDTO pDto = new PanierDTO();
		pDto.setDateCreation(panier.getDateCreation());
		pDto.setDateLivraison(panier.getDateLivraison());
		pDto.setId(panier.getId());
		pDto.setMembreId(panier.getMembre().getId());
		List<LivreDTO> livres = new ArrayList<LivreDTO>();
		panier.getLivres().forEach(l -> livres.add(livreMapper.livreToLivreDTO(l)));
		pDto.setLivres(livres);
		return pDto;
	}

	public Panier toPanier(PanierDTO pDto) throws Exception {

		Panier panier = new Panier();
		panier.setDateCreation(pDto.getDateCreation());
		panier.setDateLivraison(pDto.getDateLivraison());
		panier.setId(pDto.getId());
		panier.setMembre(membreService.get(pDto.getMembreId()));
		List<Livre> livres = new ArrayList<>();
		pDto.getLivres().forEach(l -> {
			try {
				livreService.get(l.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		panier.setLivres(livres);
		return panier;
	}

}
