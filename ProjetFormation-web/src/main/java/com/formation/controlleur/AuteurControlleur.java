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

import com.formation.dto.AuteurDTO;
import com.formation.entities.Auteur;
import com.formation.service.AuteurService;

@RestController
public class AuteurControlleur {
	@Autowired
	private AuteurService auteurService;

	@GetMapping(value="/auteur")
	private List<AuteurDTO> listerAuteurs() {
		List<AuteurDTO> resultats = new ArrayList<AuteurDTO>();
		List<Auteur> auteurs = auteurService.getAll();
		
		auteurs.forEach(a -> {
			AuteurDTO auteurDto = new AuteurDTO(a.getNom(), a.getPrenom(), a.getBiographie(), a.getImagePath());
			auteurDto.setId(a.getId());
			resultats.add(auteurDto);
		});

		return resultats;
	}
	
	@GetMapping(value="/auteur/{id}")
	private AuteurDTO getAuteur(@PathVariable(value="id") int id) {
		Auteur auteur = auteurService.get(id);
		AuteurDTO auteurDto = new AuteurDTO(auteur.getNom(), auteur.getPrenom(), auteur.getBiographie(), auteur.getImagePath());
		
		return auteurDto;
		
	}
	
	@PutMapping(value="/auteur", consumes=  MediaType.APPLICATION_JSON_VALUE)
	private void ajoutAuteur(@RequestBody AuteurDTO auteurDto) {
		Auteur auteur = new Auteur(auteurDto.getNom(), auteurDto.getPrenom(), auteurDto.getBiographie(), auteurDto.getImagePath());
		auteurService.save(auteur);
	}
	

	@PostMapping(value = "/auteur/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	private void updateAuteur(@RequestBody AuteurDTO auteurDto, @PathVariable(value="id") int id){
		Auteur auteur = auteurService.get(id);
		auteur.setBiographie(auteurDto.getBiographie());
		auteur.setNom(auteurDto.getNom());
		auteur.setPrenom(auteurDto.getPrenom());
		auteur.setImagePath(auteurDto.getImagePath());
		
		auteurService.save(auteur);
	}
	
	@DeleteMapping(value="/auteur/{id}")
	private void deleteAuteur(@PathVariable(value="id") int id) {
		auteurService.delete(auteurService.get(id));
	}
}
