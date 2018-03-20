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
import com.formation.exception.ServiceException;
import com.formation.service.BibliothequeService;
import com.formation.service.ExemplaireService;
import com.formation.service.RayonService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;

@RestController
public class RayonControlleur {

	@Autowired
	private RayonService rayonService;

	@Autowired
	private BibliothequeService bibliothequeService;

	@Autowired
	private ExemplaireService exemplaireService;

	@GetMapping(value = "/admin/rayon")
	public Resultat listerRayon(){

		List<RayonDTO> listeRayons = new ArrayList<RayonDTO>();
		Resultat resultat = new Resultat();
		try {
			List<Rayon> Rayons = rayonService.getAll();
			Rayons.forEach(rayon -> {

				RayonDTO rayonDto = new RayonDTO(rayon.getNom(), rayon.getDescription(), rayon.getNbrLivres(),
						rayon.getBibliotheque().getId());
				rayonDto.setId(rayon.getId());
				List<Integer> exemplaires = new ArrayList<Integer>();
				rayon.getExemplaires().forEach(ex -> exemplaires.add(ex.getId()));
				rayonDto.setExemlplairesId(exemplaires);
				listeRayons.add(rayonDto);
				resultat.setPayload(listeRayons);
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

	@PutMapping(value = "/admin/rayon", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat ajouterRayon(@RequestBody RayonDTO rayonDto) {
		Resultat resultat = new Resultat();
		try {
			Rayon rayon = new Rayon(rayonDto.getNom(),rayonDto.getDescription(),rayonDto.getNbrLivres());
			rayon.setBibliotheque(bibliothequeService.get(rayonDto.getId()));
			rayon.setExemplaires(exemplaireService.getExemplaireById(rayonDto.getExemlplairesId()));
			rayon.setBibliotheque(bibliothequeService.get(rayonDto.getBibliothequeId()));
			rayonService.save(rayon);
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

	@PostMapping(value = "/admin/rayon")
	public Resultat editerRayon(@RequestBody RayonDTO rayonDto) {
		Resultat resultat = new Resultat();
		try {
			Rayon rayon = new Rayon();
			rayon.setId(rayonDto.getId());
			rayon.setNom(rayonDto.getNom());
			rayon.setDescription(rayonDto.getDescription());
			rayon.setNbrLivres(rayonDto.getNbrLivres());
			rayon.setBibliotheque(bibliothequeService.get(rayonDto.getBibliothequeId()));
			List<Exemplaire> exemplaires = new ArrayList<>();
			for (int i = 0; i < rayonDto.getExemlplairesId().size(); i++) {
				exemplaires.add(exemplaireService.get(i));
			}
			rayon.setExemplaires(exemplaires);
			rayonService.save(rayon);
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

	@DeleteMapping(value = "/admin/rayon")
	private Resultat supprRayon(@RequestBody RayonDTO rayonDto) {
		Resultat resultat = new Resultat();
		try {
			Rayon rayon = new Rayon();
			rayon = rayonService.get(rayonDto.getId());
			rayonService.delete(rayon);
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