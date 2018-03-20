package com.formation.controlleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.CategorieDTO;
import com.formation.dto.MembreDTO;
import com.formation.entities.Categorie;
import com.formation.entities.Inscription;
import com.formation.entities.Membre;
import com.formation.exception.ServiceException;
import com.formation.service.CategorieService;
import com.formation.service.LivreService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;

@RestController
public class CategorieControlleur {

	@Autowired
	private CategorieService categorieService;

	@Autowired
	private LivreService livreService;

	@PutMapping(value = "/categorie")
	public Resultat ajoutCategorie(@RequestBody CategorieDTO categorieDto) {
		Resultat resultat = new Resultat();
		try {
			Categorie newCategorie = new Categorie(categorieDto.getNom(), categorieDto.getDescription());
			categorieService.save(newCategorie);
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

	@GetMapping(value = "/categorie")
	public Resultat listerCategories() {
		List<CategorieDTO> listeCategories = new ArrayList<CategorieDTO>();
		Resultat resultat = new Resultat();
		try {
			List<Categorie> listeCategorie = categorieService.getAll();

			listeCategorie.forEach(categorie -> {
				CategorieDTO categorieDto = new CategorieDTO(categorie.getNom(), categorie.getDescription());
				categorieDto.setId(categorie.getId());
				listeCategories.add(categorieDto);
				resultat.setPayload(listeCategories);
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

	@PostMapping(value = "/categorie/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat updateCategorie(@RequestBody CategorieDTO categorieDto, @PathVariable(value="id") int id){
		Resultat resultat = new Resultat();
		try {
			Categorie categorie = categorieService.get(id);
			categorie.setNom(categorieDto.getNom());
			categorie.setDescription(categorieDto.getDescription());
			categorieService.save(categorie);
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

	@DeleteMapping(value="/categorie/{id}")
	private Resultat deleteCategorie(@PathVariable(value="id") int id) {
		Resultat resultat = new Resultat();
		try {
			categorieService.delete(categorieService.get(id));
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
