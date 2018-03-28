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

import com.formation.dto.EditeurDTO;
import com.formation.entities.Editeur;
import com.formation.exception.ServiceException;
import com.formation.service.EditeurService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;

@RestController
public class EditeurControlleur {

	@Autowired
	private EditeurService editeurService;

	@PutMapping(value = "/editeur")
	public Resultat ajoutEditeur(@RequestBody EditeurDTO editeurDto) {
		Resultat resultat = new Resultat();
		try {
			Editeur newEditeur = new Editeur(editeurDto.getNom(), editeurDto.getAdresse());
			editeurService.save(newEditeur);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.AJOUT_EDITEUR_SUCCESS);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.AJOUT_EDITEUR_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

	@GetMapping(value = "/editeur")
	public Resultat listerEditeurs() {
		List<EditeurDTO> listeEditeur = new ArrayList<EditeurDTO>();
		Resultat resultat = new Resultat();
		try {
			List<Editeur> listeEditeurs = editeurService.getAll();

			listeEditeurs.forEach(editeur -> {
				EditeurDTO editeurDto = new EditeurDTO(editeur.getNom(), editeur.getAdresse());
				editeurDto.setId(editeur.getId());
				listeEditeur.add(editeurDto);
				resultat.setPayload(listeEditeur);

			});
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LISTE_EDITEUR_SUCCESS);
		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LISTE_EDITEUR_ERROR);

			e.printStackTrace();
		}

		return resultat;
	}

	@PostMapping(value = "/editeur/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat updateEditeur(@RequestBody EditeurDTO editeurDto, @PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();
		try {
			Editeur editeur = editeurService.get(id);
			editeur.setNom(editeurDto.getNom());
			editeur.setAdresse(editeurDto.getAdresse());
			editeurService.save(editeur);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.MODIF_EDITEUR_SUCCESS);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.MODIF_EDITEUR_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

	@DeleteMapping(value = "/editeur/{id}")
	private Resultat deleteEditeur(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();
		try {
			editeurService.delete(editeurService.get(id));
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.SUPPR_EDITEUR_SUCCESS);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.SUPPR_EDITEUR_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

}
