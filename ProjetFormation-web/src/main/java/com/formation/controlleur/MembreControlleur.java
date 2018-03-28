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

import com.formation.dto.MembreDTO;
import com.formation.entities.Inscription;
import com.formation.entities.Membre;
import com.formation.exception.ServiceException;
import com.formation.service.InscriptionService;
import com.formation.service.MembreService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;

@RestController
public class MembreControlleur {

	@Autowired
	private MembreService membreService;

	@Autowired
	private InscriptionService inscriptionService;

	@PutMapping(value = "/admin/membre")
	public Resultat ajoutMembre(@RequestBody MembreDTO membreDto) {
		Resultat resultat = new Resultat();
		try {
			Membre newMembre = new Membre(membreDto.getNom(), membreDto.getPrenom(), membreDto.getEmail(),
					membreDto.getPassword(), membreDto.getAdresse(), membreDto.getVille(), membreDto.getCodePostal(),
					membreDto.getTelephone(), membreDto.isAdmin());
//			newMembre.setInscriptions(inscriptionService.getInscriptionById(membreDto.getInscriptionsId()));
			newMembre.setPassword(membreService.cryptageMdp(newMembre.getPassword()));
			membreService.save(newMembre);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.AJOUT_MEMBRE_SUCCESS);
			resultat.setPayload(newMembre);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.AJOUT_MEMBRE_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

	@GetMapping(value = "/admin/membre")
	public Resultat listerMembres() {
		List<MembreDTO> listeMembre = new ArrayList<MembreDTO>();
		Resultat resultat = new Resultat();
		try {
			List<Membre> listeMembres = membreService.getAll();

			listeMembres.forEach(membre -> {
				MembreDTO membreDto = new MembreDTO(membre.getNom(), membre.getPrenom(), membre.getPassword(),
						membre.getAdresse(), membre.getVille(), membre.getCodePostal(), membre.getTelephone(),
						membre.getEmail(), membre.isAdmin());
				List<Integer> inscriptionIds = new ArrayList<Integer>();

				membre.getInscriptions().forEach(inscription -> inscriptionIds.add(inscription.getId()));
				membreDto.setInscriptionsId(inscriptionIds);

				int test = 0;
				test = membre.getId();
				if (test != 0) {
					membreDto.setId(membre.getId());
				}

				listeMembre.add(membreDto);
				resultat.setPayload(listeMembre);
			});
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LISTE_MEMBRE_SUCCESS);
		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.LISTE_MEMBRE_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

	@PostMapping(value = "/admin/membre/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat updateMembre(@RequestBody MembreDTO membreDto, @PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();
		try {
			Membre membre = membreService.get(id);
			membre.setNom(membreDto.getNom());
			membre.setPrenom(membreDto.getPrenom());
			membre.setPassword(membreDto.getPassword());
			membre.setAdresse(membreDto.getAdresse());
			membre.setVille(membreDto.getVille());
			membre.setCodePostal(membreDto.getCodePostal());
			membre.setTelephone(membreDto.getTelephone());
			membre.setEmail(membreDto.getEmail());
			membre.setAdmin(membreDto.isAdmin());
			List<Inscription> inscriptions = new ArrayList<>();
			for (int i = 0; i < membreDto.getInscriptionsId().size(); i++) {
				inscriptions.add(inscriptionService.get(i));
			}
			membre.setInscriptions(inscriptions);

			membreService.save(membre);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.MODIF_MEMBRE_SUCCESS);
		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.MODIF_MEMBRE_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}

	@DeleteMapping(value = "/admin/membre/{id}")
	private Resultat deleteMembre(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();
		try {
			membreService.delete(membreService.get(id));
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.SUPPR_MEMBRE_SUCCESS);

		} catch (ServiceException se) {
			resultat.setSuccess(false);
			resultat.setMessage(se.getMessage());
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.SUPPR_MEMBRE_ERROR);

			e.printStackTrace();
		}
		return resultat;
	}
}
