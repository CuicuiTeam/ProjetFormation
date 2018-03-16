package com.formation.controlleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.BibliothequeDTO;
import com.formation.dto.RayonDTO;
import com.formation.entities.Rayon;
import com.formation.service.RayonService;

@RestController
public class RayonControlleur {

	@Autowired
	private RayonService rayonService;

	@Autowired
	private BibliothequeService bibliothequeService;

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
			rayonDto.setExemlplairesId(exemplaires);
			resultats.add(rayonDto);
		});
		return resultats;
	}

	@PutMapping(value = "/admin/rayon", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void ajouterRayon(@RequestBody RayonDTO rayonDto)
		Rayon rayon = new Rayon(rayonDto.getNom(),rayonDto.getDescription(),rayonDto.getNbrLivres());
		rayon.setBibliotheque(Service.get(rayonDto.getId()));

}
