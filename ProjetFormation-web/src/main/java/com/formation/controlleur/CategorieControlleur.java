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
import com.formation.service.CategorieService;
import com.formation.service.LivreService;

@RestController
public class CategorieControlleur {
	
	@Autowired
	private CategorieService categorieService;
	
	@Autowired
	private LivreService livreService;
	
	@PutMapping(value = "/categorie")
	public void ajoutCategorie(@RequestBody CategorieDTO categorieDto) {
		
		Categorie newCategorie = new Categorie(categorieDto.getNom(), categorieDto.getDescription());
		categorieService.save(newCategorie);
	}
	
	@GetMapping(value = "/categorie")
	public List<CategorieDTO> listerCategories() {
		List<CategorieDTO> resultats = new ArrayList<CategorieDTO>();
		List<Categorie> listeCategorie = categorieService.getAll();
		
		listeCategorie.forEach(categorie -> {
			CategorieDTO categorieDto = new CategorieDTO(categorie.getNom(), categorie.getDescription());
			categorieDto.setId(categorie.getId());
			resultats.add(categorieDto);
		});
		
		return resultats;
	}
	
	@PostMapping(value = "/categorie/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	   public void updateCategorie(@RequestBody CategorieDTO categorieDto, @PathVariable(value="id") int id){

	       Categorie categorie = categorieService.get(id);
	       categorie.setNom(categorieDto.getNom());
	       categorie.setDescription(categorieDto.getDescription());
	       categorieService.save(categorie);
	   }
	
	@DeleteMapping(value="/categorie/{id}")
    private void deleteCategorie(@PathVariable(value="id") int id) {
        categorieService.delete(categorieService.get(id));
    }

}
