package com.formation.controlleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.BibliothequeDTO;
import com.formation.entities.Bibliotheque;
import com.formation.exception.ServiceException;
import com.formation.service.BibliothequeService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;

@RestController
public class BibliothequeControlleur {

	@Autowired
	private BibliothequeService bibliothequeService;

	@GetMapping("/admin/bibliotheque")
	public Resultat listerBibliotheque() {
		List<BibliothequeDTO> listeBibliotheques = new ArrayList<BibliothequeDTO>();
		Resultat resultat = new Resultat();
		try {
			List<Bibliotheque> bibliotheques = bibliothequeService.getAll();

			bibliotheques.forEach(bibliotheque -> {

				BibliothequeDTO biblioDto = new BibliothequeDTO(bibliotheque.getNom(), bibliotheque.getAdresse());
				biblioDto.setId(bibliotheque.getId());
				listeBibliotheques.add(biblioDto);
				resultat.setPayload(listeBibliotheques);
			});
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LISTE_BIBLIO_SUCCESS);
		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LISTE_BIBLIO_ERROR);

			e.printStackTrace();
		}
		return resultat;

	}

	@PutMapping(value = "/admin/bibliotheque", consumes = MediaType.APPLICATION_JSON_VALUE)
	private Resultat ajouterBibliotheque(@RequestBody BibliothequeDTO biblioDto) {
		Resultat resultat = new Resultat();
		try {
			Bibliotheque biblio = new Bibliotheque(biblioDto.getNom(), biblioDto.getAdresse());
			bibliothequeService.save(biblio);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.AJOUT_BIBLIO_SUCCESS);
		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.AJOUT_BIBLIO_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

	@PostMapping(value = "/admin/bibliotheque")
	private Resultat editerBibliotheque(@RequestBody BibliothequeDTO biblioDto) {
		Resultat resultat = new Resultat();
		try {
			Bibliotheque bibliotheque = new Bibliotheque();
			bibliotheque.setId(biblioDto.getId());
			bibliotheque.setNom(biblioDto.getNom());
			bibliotheque.setAdresse(biblioDto.getAdresse());

			bibliothequeService.save(bibliotheque);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.MODIF_BIBLIO_SUCCESS);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.MODIF_BIBLIO_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

	@DeleteMapping(value = "/admin/bibliotheque")
	private Resultat supprBibliotheque(@RequestBody BibliothequeDTO biblioDto) {
		Resultat resultat = new Resultat();
		try {
			Bibliotheque bibliotheque = new Bibliotheque();
			bibliotheque = bibliothequeService.get(biblioDto.getId());
			bibliothequeService.delete(bibliotheque);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.SUPPR_BIBLIO_SUCCESS);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.SUPPR_BIBLIO_ERROR);

			e.printStackTrace();
		}
		return resultat;

	}

}
