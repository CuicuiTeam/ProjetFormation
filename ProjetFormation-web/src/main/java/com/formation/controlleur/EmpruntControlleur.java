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
import com.formation.entities.Emprunt;
import com.formation.exception.ServiceException;
import com.formation.service.EmpruntService;
import com.formation.service.MembreService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;

@RestController
public class EmpruntControlleur {
	@Autowired
	private EmpruntService empruntService;

	@Autowired
	private MembreService membreService;

	@GetMapping(value="/emprunt")
	private Resultat listerEmprunts() {
		List<EmpruntDTO> listeEmprunts = new ArrayList<EmpruntDTO>();
		Resultat resultat = new Resultat();
		try {
			List<Emprunt> emprunts = empruntService.getAll();

			emprunts.forEach(e -> {
				EmpruntDTO empruntDto = new EmpruntDTO(e.getDateEmprunt(), e.getDateRetour(), e.getMembre().getId());
				empruntDto.setId(e.getId());
				listeEmprunts.add(empruntDto);
				resultat.setPayload(listeEmprunts);
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

	@GetMapping(value="/emprunt/{id}")
	private Resultat getEmprunt(@PathVariable(value="id") int id) {
		Resultat resultat = new Resultat();
		try {
			Emprunt emprunt = empruntService.get(id);
			EmpruntDTO empruntDto = new EmpruntDTO(emprunt.getDateEmprunt(), emprunt.getDateRetour(), emprunt.getMembre().getId());
			resultat.setPayload(empruntDto);
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

	@PutMapping(value="/emprunt", consumes=  MediaType.APPLICATION_JSON_VALUE)
	private Resultat ajoutEmprunt(@RequestBody EmpruntDTO empruntDto) {
		Resultat resultat = new Resultat();
		try {
			Emprunt emprunt = new Emprunt(membreService.get(empruntDto.getMembreId()), empruntDto.getDateEmprunt(), empruntDto.getDateRetour());
			empruntService.save(emprunt);
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

	@PostMapping(value = "/emprunt/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	private Resultat updateEmprunt(@RequestBody EmpruntDTO empruntDto, @PathVariable(value="id") int id){
		Resultat resultat = new Resultat();
		try {
			Emprunt emprunt = empruntService.get(id);
			emprunt.setMembre(membreService.get(empruntDto.getMembreId()));
			emprunt.setDateEmprunt(empruntDto.getDateEmprunt());
			emprunt.setDateRetour(empruntDto.getDateRetour());

			empruntService.save(emprunt);
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

	@DeleteMapping(value="/emprunt/{id}")
	private Resultat deleteEmprunt(@PathVariable(value="id") int id) {
		Resultat resultat = new Resultat();
		try {
			empruntService.delete(empruntService.get(id));
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
