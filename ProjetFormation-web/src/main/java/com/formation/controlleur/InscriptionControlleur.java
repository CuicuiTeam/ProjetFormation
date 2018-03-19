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
import com.formation.entities.Exemplaire;
import com.formation.entities.Inscription;
import com.formation.service.BibliothequeService;
import com.formation.service.InscriptionService;
import com.formation.service.InscriptionService;
import com.formation.service.MembreService;
import com.formation.dto.InscriptionDTO;

@RestController
public class InscriptionControlleur {

	@Autowired
	private InscriptionService inscriptionService;
	
	@Autowired
	private MembreService membreService;
	
	@Autowired 
	private BibliothequeService bibliothequeService;
	
	@GetMapping(value="/inscription")
	private List<InscriptionDTO> listerInscriptions() {
		List<InscriptionDTO> resultats = new ArrayList<>();
		List<Inscription> inscriptions= inscriptionService.getAll();
		
		inscriptions.forEach(i -> {
			InscriptionDTO inscriptionDto = new InscriptionDTO(i.getDateInscription(), i.getBibliotheque().getId(), i.getMembre().getId());
			inscriptionDto.setId(i.getId());
			resultats.add(inscriptionDto);
		});

		return resultats;
	}
	
	@GetMapping(value="/inscription/{id}")
	private InscriptionDTO getInscription(@PathVariable(value="id") int id) {
		Inscription inscription = inscriptionService.get(id);
		InscriptionDTO inscriptionDto = new InscriptionDTO(inscription.getDateInscription(), inscription.getBibliotheque().getId(), inscription.getMembre().getId());
		
		return inscriptionDto;
	}
	
	@PutMapping(value="/inscription", consumes=  MediaType.APPLICATION_JSON_VALUE)
	private void ajoutinscription(@RequestBody InscriptionDTO inscriptionDto) {
		Inscription inscription = new Inscription(bibliothequeService.get(inscriptionDto.getBibliothequeId()), membreService.get(inscriptionDto.getMembreId()), inscriptionDto.getDateInscription());
		inscriptionService.save(inscription);
	}
	
	@PostMapping(value = "/inscription/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	private void updateInscription(@RequestBody InscriptionDTO inscriptionDto, @PathVariable(value="id") int id){
		Inscription inscription = inscriptionService.get(id);
		inscription.setBibliotheque(bibliothequeService.get(inscriptionDto.getBibliothequeId()));
		inscription.setMembre(membreService.get(inscriptionDto.getMembreId()));
		inscription.setDateInscription(inscriptionDto.getDateInscription());
		inscriptionService.save(inscription);
	}
	
	@DeleteMapping(value="/inscription/{id}")
	private void deleteInscription(@PathVariable(value="id") int id) {
		inscriptionService.delete(inscriptionService.get(id));
	}
	
}
