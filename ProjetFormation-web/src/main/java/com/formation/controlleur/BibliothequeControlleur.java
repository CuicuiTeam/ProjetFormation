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

import com.formation.dto.BibliothequeDTO;
import com.formation.entities.Bibliotheque;
import com.formation.service.BibliothequeService;

@RestController
public class BibliothequeControlleur {

	@Autowired
	private BibliothequeService bibliothequeService;

	@GetMapping("/admin/bibliotheque")
	public List<BibliothequeDTO> listerBibliotheque() {
		List<BibliothequeDTO> resultats = new ArrayList<BibliothequeDTO>();
		List<Bibliotheque> bibliotheques = bibliothequeService.getAll();

		bibliotheques.forEach(bibliotheque -> {

			BibliothequeDTO biblioDto = new BibliothequeDTO(bibliotheque.getNom(), bibliotheque.getAdresse());
			biblioDto.setId(bibliotheque.getId());
			resultats.add(biblioDto);
		});
		return resultats;

	}

	@PutMapping(value = "/admin/bibliotheque", consumes = MediaType.APPLICATION_JSON_VALUE)
	private void ajouterBibliotheque(@RequestBody BibliothequeDTO biblioDto) {
		Bibliotheque biblio = new Bibliotheque(biblioDto.getNom(), biblioDto.getAdresse());
		bibliothequeService.save(biblio);
	}

	@PostMapping(value = "/admin/bibliotheque")
	private void editerBibliotheque(@RequestBody BibliothequeDTO biblioDto) {
		Bibliotheque bibliotheque = new Bibliotheque();
		bibliotheque.setId(biblioDto.getId());
		bibliotheque.setNom(biblioDto.getNom());
		bibliotheque.setAdresse(biblioDto.getAdresse());

		bibliothequeService.save(bibliotheque);
	}

	@DeleteMapping(value = "/admin/bibliotheque")
	private void supprBibliotheque(@RequestBody BibliothequeDTO biblioDto) {
		Bibliotheque bibliotheque = new Bibliotheque();
		bibliotheque = bibliothequeService.get(biblioDto.getId());
		bibliothequeService.delete(bibliotheque);

	}

}
