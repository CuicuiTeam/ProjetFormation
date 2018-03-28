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

import com.formation.dto.InscriptionDTO;
import com.formation.entities.Inscription;
import com.formation.exception.ServiceException;
import com.formation.service.BibliothequeService;
import com.formation.service.InscriptionService;
import com.formation.service.MembreService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;

@RestController
public class InscriptionControlleur {

	@Autowired
	private InscriptionService inscriptionService;

	@Autowired
	private MembreService membreService;

	@Autowired 
	private BibliothequeService bibliothequeService;

	@GetMapping(value="/admin/inscription")
	private Resultat listerInscriptions() {
		List<InscriptionDTO> listeInscriptions = new ArrayList<>();
		Resultat resultat = new Resultat();
		try {
			List<Inscription> inscriptions= inscriptionService.getAll();

			inscriptions.forEach(i -> {
				InscriptionDTO inscriptionDto = new InscriptionDTO(i.getDateInscription(), i.getBibliotheque().getId(), i.getMembre().getId());
				inscriptionDto.setId(i.getId());
				listeInscriptions.add(inscriptionDto);
				resultat.setPayload(listeInscriptions);
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

	@GetMapping(value="/admin/inscription/{id}")
	private Resultat getInscription(@PathVariable(value="id") int id) {
		Resultat resultat = new Resultat();
		try {
			Inscription inscription = inscriptionService.get(id);
			InscriptionDTO inscriptionDto = new InscriptionDTO(inscription.getDateInscription(), inscription.getBibliotheque().getId(), inscription.getMembre().getId());
			resultat.setPayload(inscriptionDto);
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

	@PutMapping(value="/admin/inscription", consumes=  MediaType.APPLICATION_JSON_VALUE)
	private Resultat ajoutinscription(@RequestBody InscriptionDTO inscriptionDto) {
		Resultat resultat = new Resultat();
		try {
			Inscription inscription = new Inscription(bibliothequeService.get(inscriptionDto.getBibliothequeId()), membreService.get(inscriptionDto.getMembreId()), inscriptionDto.getDateInscription());
			inscriptionService.save(inscription);
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

	@PostMapping(value = "/admin/inscription/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	private Resultat updateInscription(@RequestBody InscriptionDTO inscriptionDto, @PathVariable(value="id") int id){
		Resultat resultat = new Resultat();
		try {
			Inscription inscription = inscriptionService.get(id);
			inscription.setBibliotheque(bibliothequeService.get(inscriptionDto.getBibliothequeId()));
			inscription.setMembre(membreService.get(inscriptionDto.getMembreId()));
			inscription.setDateInscription(inscriptionDto.getDateInscription());
			inscriptionService.save(inscription);
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

	@DeleteMapping(value="/admin/inscription/{id}")
	private Resultat deleteInscription(@PathVariable(value="id") int id) {
		Resultat resultat = new Resultat();
		try {
			inscriptionService.delete(inscriptionService.get(id));
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
