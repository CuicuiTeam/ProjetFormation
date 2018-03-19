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

import com.formation.dto.CategorieDTO;
import com.formation.dto.EditeurDTO;
import com.formation.entities.Categorie;
import com.formation.entities.Editeur;
import com.formation.service.EditeurService;

@RestController
public class EditeurControlleur {

	@Autowired
	private EditeurService editeurService;

	@PutMapping(value = "/editeur")
	public void ajoutEditeur(@RequestBody EditeurDTO editeurDto) {

		Editeur newEditeur = new Editeur(editeurDto.getNom(), editeurDto.getAdresse());
		editeurService.save(newEditeur);
	}

	@GetMapping(value = "/editeur")
	public List<EditeurDTO> listerEditeurs() {
		List<EditeurDTO> resultats = new ArrayList<EditeurDTO>();
		List<Editeur> listeEditeurs = editeurService.getAll();

		listeEditeurs.forEach(editeur -> {
			EditeurDTO editeurDto = new EditeurDTO(editeur.getNom(), editeur.getAdresse());
			editeurDto.setId(editeur.getId());
			resultats.add(editeurDto);
		});

		return resultats;
	}

	@PostMapping(value = "/editeur/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateEditeur(@RequestBody EditeurDTO editeurDto, @PathVariable(value = "id") int id) {

		Editeur editeur = editeurService.get(id);
		editeur.setNom(editeurDto.getNom());
		editeur.setAdresse(editeurDto.getAdresse());
		editeurService.save(editeur);
	}

	@DeleteMapping(value = "/editeur/{id}")
	private void deleteEditeur(@PathVariable(value = "id") int id) {
		editeurService.delete(editeurService.get(id));
	}

}
