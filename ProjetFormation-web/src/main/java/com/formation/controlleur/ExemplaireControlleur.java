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

import com.formation.dto.ExemplaireDTO;
import com.formation.entities.Exemplaire;
import com.formation.exception.ServiceException;
import com.formation.service.EmpruntService;
import com.formation.service.ExemplaireService;
import com.formation.service.LivreService;
import com.formation.service.MembreService;
import com.formation.service.RayonService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;

@RestController
public class ExemplaireControlleur {
	@Autowired
	private ExemplaireService exemplaireService;

	@Autowired 
	private RayonService rayonService;

	@Autowired 
	private LivreService livreService;

	@Autowired
	private MembreService membreService;

	@Autowired
	private EmpruntService empruntService;

	@GetMapping(value="/exemplaire")
	private Resultat listerExemplaires() {
		List<ExemplaireDTO> listeExemplaires = new ArrayList<>();
		Resultat resultat = new Resultat();
		try {
			List<Exemplaire> exemplaires= exemplaireService.getAll();

			exemplaires.forEach(e -> {
				ExemplaireDTO exemplaireDto = new ExemplaireDTO(e.getRayon().getId(), e.getLivre().getId(), e.getMembre().getId(), e.getEmprunt().getId());
				exemplaireDto.setId(e.getId());
				listeExemplaires.add(exemplaireDto);
				resultat.setPayload(listeExemplaires);
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

	@GetMapping(value="/exemplaire/{id}")
	private Resultat getExemplaire(@PathVariable(value="id") int id) {
		Resultat resultat = new Resultat();
		try {
			Exemplaire exemplaire = exemplaireService.get(id);
			ExemplaireDTO exemplaireDto = new ExemplaireDTO(exemplaire.getRayon().getId(), exemplaire.getLivre().getId(), exemplaire.getMembre().getId(), exemplaire.getEmprunt().getId());
			resultat.setPayload(exemplaireDto);
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

	@PutMapping(value="/exemplaire", consumes=  MediaType.APPLICATION_JSON_VALUE)
	private Resultat ajoutExemplaire(@RequestBody ExemplaireDTO exemplaireDto) {
		Resultat resultat = new Resultat();
		try {
			Exemplaire exemplaire = new Exemplaire(rayonService.get(exemplaireDto.getRayonId()), livreService.get(exemplaireDto.getLivreId()));
			exemplaireService.save(exemplaire);
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


	@PostMapping(value = "/exemplaire/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	private Resultat updateAuteur(@RequestBody ExemplaireDTO exemplaireDto, @PathVariable(value="id") int id){
		Resultat resultat = new Resultat();
		try {
			Exemplaire exemplaire = exemplaireService.get(id);
			exemplaire.setLivre(livreService.get(exemplaireDto.getLivreId()));
			exemplaire.setRayon(rayonService.get(exemplaireDto.getRayonId()));
			exemplaire.setMembre(membreService.get(exemplaireDto.getMembreId()));
			exemplaire.setEmprunt(empruntService.get(exemplaireDto.getEmpruntId()));

			exemplaireService.save(exemplaire);
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

	@DeleteMapping(value="/exemplaire/{id}")
	private Resultat deleteExemplaire(@PathVariable(value="id") int id) {
		Resultat resultat = new Resultat();
		try {
			exemplaireService.delete(exemplaireService.get(id));
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
