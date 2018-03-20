package com.formation.controlleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.EmpruntDTO;
import com.formation.dto.PanierDTO;
import com.formation.entities.Emprunt;
import com.formation.entities.Panier;
import com.formation.exception.ServiceException;
import com.formation.service.MembreService;
import com.formation.service.PanierService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;

@RestController
public class PanierControlleur {

	@Autowired
	private PanierService panierService;

	@Autowired
	private MembreService membreService;

	@GetMapping(value="/panier")
	private Resultat listerPaniers() {
		List<PanierDTO> listePaniers = new ArrayList<PanierDTO>();
		Resultat resultat = new Resultat();
		try {
			List<Panier> paniers = panierService.getAll();

			paniers.forEach(p -> {
				PanierDTO panierDto = new PanierDTO(p.getDateCreation(), p.getDateLivraison(), p.getMembre().getId());
				panierDto.setId(p.getId());
				listePaniers.add(panierDto);
				resultat.setPayload(listePaniers);
			});
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);
		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGIN_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

	@GetMapping(value="/panier/{id}")
	private Resultat getPanier(@PathVariable(value="id") int id) {
		Resultat resultat = new Resultat();
		try {
			Panier panier = panierService.get(id);
			PanierDTO panierDto = new PanierDTO(panier.getDateCreation(), panier.getDateLivraison(), panier.getMembre().getId());
			resultat.setPayload(panierDto);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);
		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGIN_ERROR);

			e.printStackTrace();
		}
		return resultat;

	}

	@PutMapping(value="/panier", consumes=  MediaType.APPLICATION_JSON_VALUE)
	private Resultat ajoutPanier(@RequestBody PanierDTO panierDto) {
		Resultat resultat = new Resultat();
		try {
			Panier panier = new Panier(panierDto.getDateCreation(), panierDto.getDateLivraison());
			panier.setMembre(membreService.get(panierDto.getMembreId()));
			panierService.save(panier);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGIN_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

	@PostMapping(value = "/panier/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	private Resultat updatePanier(@RequestBody PanierDTO panierDto, @PathVariable(value="id") int id){
		Resultat resultat = new Resultat();
		try {
			Panier panier = panierService.get(id);
			panier.setMembre(membreService.get(panierDto.getMembreId()));
			panier.setDateCreation(panierDto.getDateCreation());
			panier.setDateLivraison(panierDto.getDateLivraison());

			panierService.save(panier);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGIN_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

	@DeleteMapping(value="/panier/{id}")
	private Resultat deletePanier(@PathVariable(value="id") int id) {
		Resultat resultat = new Resultat();
		try {
			panierService.delete(panierService.get(id));
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LOGIN_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}
}
