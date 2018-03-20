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

import com.formation.dto.RayonDTO;
import com.formation.entities.Exemplaire;
import com.formation.entities.Rayon;
import com.formation.service.BibliothequeService;
import com.formation.service.ExemplaireService;
import com.formation.service.RayonService;

@RestController
public class RayonControlleur {

	@Autowired
	private RayonService rayonService;

	@Autowired
	private BibliothequeService bibliothequeService;

	@Autowired
	private ExemplaireService exemplaireService;

	@GetMapping(value = "/admin/rayon")
	public List<RayonDTO> listerRayon(){
		
		List<RayonDTO> resultats = new ArrayList<RayonDTO>();
		List<Rayon> Rayons = rayonService.getAll();
		Rayons.forEach(rayon -> {

			RayonDTO rayonDto = new RayonDTO(rayon.getNom(), rayon.getDescription(), rayon.getNbrLivres(),
					rayon.getBibliotheque().getId());
			rayonDto.setId(rayon.getId());
			List<Integer> exemplaires = new ArrayList<Integer>();
			rayon.getExemplaires().forEach(ex -> exemplaires.add(ex.getId()));
			rayonDto.setExemplairesId(exemplaires);
			resultats.add(rayonDto);
		});
		return resultats;
	}

	@PutMapping(value = "/admin/rayon", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void ajouterRayon(@RequestBody RayonDTO rayonDto) {
		Rayon rayon = new Rayon(rayonDto.getNom(),rayonDto.getDescription(),rayonDto.getNbrLivres());
		rayon.setBibliotheque(bibliothequeService.get(rayonDto.getId()));
		rayon.setExemplaires(exemplaireService.getExemplaireById(rayonDto.getExemplairesId()));
		rayonService.save(rayon);
	}

	@PostMapping(value = "/admin/rayon")
	public void editerRayon(@RequestBody RayonDTO rayonDto) {
		Rayon rayon = new Rayon();
		rayon.setNom(rayonDto.getNom());
		rayon.setDescription(rayonDto.getDescription());
		rayon.setNbrLivres(rayonDto.getNbrLivres());
		rayon.setBibliotheque(bibliothequeService.get(rayonDto.getBibliothequeId()));
		List<Exemplaire> exemplaires = new ArrayList<>();
		for (int i = 0; i < rayonDto.getExemplairesId().size(); i++) {
			exemplaires.add(exemplaireService.get(i));
		}
		rayon.setExemplaires(exemplaires);
		rayonService.save(rayon);
	}

	@DeleteMapping(value = "/admin/rayon")
	private void supprRayon(@RequestBody RayonDTO rayonDto) {
		Rayon rayon = new Rayon();
		rayon = rayonService.get(rayonDto.getId());
		rayonService.delete(rayon);
	}

}
