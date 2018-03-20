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

import com.formation.dto.LivreDTO;
import com.formation.entities.Auteur;
import com.formation.entities.Livre;
import com.formation.service.AuteurService;
import com.formation.service.CategorieService;
import com.formation.service.EditeurService;
import com.formation.service.LivreService;

@RestController
public class LivreControlleur {

	@Autowired
	private LivreService livreService;

	@Autowired
	private AuteurService auteurService;

	@Autowired
	private CategorieService categorieService;

	@Autowired
	private EditeurService editeurService;

	@GetMapping(value = "/livre")
	public List<LivreDTO> listerLivres() {
		List<LivreDTO> resultats = new ArrayList<LivreDTO>();
		List<Livre> listeLivres = livreService.getAll();

		listeLivres.forEach(livre -> {
			LivreDTO livreDto = new LivreDTO(livre.getTitre(), livre.getDescription(), livre.getPrix(),
					livre.getDatePublication(), livre.getImagePath(), livre.isPopular(), livre.isPeriodic(),
					livre.getEditeur().getId(), livre.getCategorie().getId());
			livreDto.setId(livre.getId());
			List<Integer> authorIds = new ArrayList<Integer>();
			livre.getAuteurs().forEach(auteur -> authorIds.add(auteur.getId()));
			livreDto.setAuteursId(authorIds);

			resultats.add(livreDto);
		});

		return resultats;
	}

	@PutMapping(value = "/livre", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void ajouterLivre(@RequestBody LivreDTO livreDto) {

		Livre newLivre = new Livre(livreDto.getTitre(), livreDto.getDescription(), livreDto.getPrix(),
				livreDto.getDatePublication(), livreDto.getImagePath(), livreDto.isPeriodic(), livreDto.isPopular());
		newLivre.setEditeur(editeurService.get(livreDto.getEditeurId()));
		newLivre.setCategorie(categorieService.get(livreDto.getCategorieId()));
		newLivre.setAuteurs(auteurService.getAuteursById(livreDto.getAuteursId()));

		livreService.save(newLivre);
	}

	@PostMapping(value = "/livre")
	public void editerLivre(@RequestBody LivreDTO livreDto) {

		Livre livre = new Livre();
		livre.setId(livreDto.getId());
		livre.setTitre(livreDto.getTitre());
		livre.setDescription(livreDto.getDescription());
		livre.setPrix(livreDto.getPrix());
		livre.setDatePublication(livreDto.getDatePublication());
		livre.setPopular(livreDto.isPopular());
		livre.setImagePath(livreDto.getImagePath());
		livre.setEditeur(editeurService.get(livreDto.getEditeurId()));
		livre.setCategorie(categorieService.get(livreDto.getCategorieId()));
		List<Auteur> auteurs = new ArrayList<>();
		for (int i = 0; i < livreDto.getAuteursId().size(); i++) {
			auteurs.add(auteurService.get(i));
		}
		livre.setAuteurs(auteurs);

		livreService.save(livre);
	}


	@DeleteMapping(value = "/livre/{id}")
	private void supprLivre(@PathVariable(value = "id") int id) {
		Livre livre = livreService.get(id);
		livreService.delete(livre);

	}

	// @RequestMapping("/livre/{liv}")
	// private String Livre(@PathVariable(value = "liv") String liv, Model model) {
	//
	// model.addAttribute("livre", livreService.getLivreBySlug(liv));
	// model.addAttribute("titre", livreService.getLivreBySlug(liv).getTitre());
	// return "livre";
	//
	// }

}
