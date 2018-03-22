package com.formation.controlleur;

import java.util.ArrayList;
import java.util.Date;
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
import com.formation.service.BibliothequeService;
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

	/////////////////////////////////////////////////////////////////////////////

	@PutMapping(value = "/admin/membre")
	public Resultat ajoutMembre(@RequestBody MembreDTO membreDto) {
		Resultat resultat = new Resultat();
		try {
			Membre newMembre = new Membre(membreDto.getNom(), membreDto.getPrenom(), membreDto.getEmail(), membreDto.getPassword(), membreDto.getAdresse(), membreDto.getVille(), membreDto.getCodePostal(), membreDto.getTelephone(), membreDto.isAdmin());
//			List<Inscription> inscriptionsMembre = null;
//			membreDto.getBibliothequesId().forEach(b -> {
//				try {
//					inscriptionsMembre.add(new Inscription(bibliothequeService.get(b), newMembre, new Date()));
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			});
//			newMembre.setInscriptions(inscriptionsMembre);
			newMembre.setPassword(membreService.cryptageMdp(newMembre.getPassword()));
			membreService.save(newMembre);
			resultat.setPayload(membreDto);
			resultat.setSuccess(true);
			resultat.setMessage(ControllerConstants.LOGIN_SUCCESS);
			resultat.setPayload(newMembre);

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

	@GetMapping(value = "/admin/membre")
	public Resultat listerMembres() {
		List<MembreDTO> listeMembre = new ArrayList<MembreDTO>();
		Resultat resultat = new Resultat();
		try {
			List<Membre> listeMembres = membreService.getAll();


			listeMembres.forEach(membre -> {			
				MembreDTO membreDto = new MembreDTO(membre.getId(), membre.getNom(), membre.getPrenom(), membre.getPassword(), membre.getAdresse(), membre.getVille(), membre.getCodePostal(), membre.getTelephone(), membre.getEmail(), membre.isAdmin());
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

	@DeleteMapping(value = "/admin/membre/{id}")
	private Resultat deleteMembre(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();
		try {
			membreService.delete(membreService.get(id));
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

	/////////////////////////////////////////////////////////////////////////////////
	// @RequestMapping(value = "/toto", method = RequestMethod.GET)
	// private String ajoutMembre(Model model) {
	//
	// Membre newMembre = new Membre();
	// model.addAttribute("newMembre", newMembre);
	// return "inscription";
	// }
	//
	// @RequestMapping(value = "/toto", method = RequestMethod.POST)
	// private String ajoutMembre(@ModelAttribute("newMembre") Membre newMembre,
	///////////////////////////////////////////////////////////////////////////////// Model
	///////////////////////////////////////////////////////////////////////////////// model)
	///////////////////////////////////////////////////////////////////////////////// {
	// newMembre.setPassword(membreService.cryptageMdp(newMembre.getPassword()));
	// if (membreService.findByEmail(newMembre.getEmail()) != null) {
	// model.addAttribute("msgErreur", "Cet email est déjà utilisé");
	// newMembre.setPassword("");
	// return "inscription";
	// } else {
	// membreService.save(newMembre);
	// return "redirect:/";
	// }
	// }

	// @RequestMapping(value = "/connexion", method = RequestMethod.GET)
	// private String connexionMembre(Model model) {
	//
	// Membre newMembre = new Membre();
	// model.addAttribute("login", newMembre);
	// return "connexion";
	// }
	//
	// @RequestMapping(value = "/connexioncheck", method = RequestMethod.POST)
	// private String connexionMembre(@ModelAttribute("login") Membre newMembre,
	// Model model, HttpServletRequest request) {
	// HttpSession session = request.getSession();
	// try {
	// Membre membre = membreService.identification(newMembre.getEmail(),
	// newMembre.getPassword());
	// } catch (ServiceException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// if(membre != null) {
	// session.setAttribute("user", membre);
	// return "redirect:/";
	// } else {
	// model.addAttribute("msgErreur", "Veuillez saisir un identifiant et un mot de
	// passe valide");
	// return "connexion";
	// }
	// }

	// @RequestMapping(value = "/supprimerMembre", method = RequestMethod.GET)
	// private String supprMembre(Model model) {
	//
	// model.addAttribute("membres", membreService.getAll());
	// return "adminmembresuppr";
	// }
	//
	// @RequestMapping(value = "/supprimerMembre", method = RequestMethod.POST)
	// private String supprMembre(HttpServletRequest request) {
	// Membre membre =
	// membreService.get(Integer.parseInt(request.getParameter("membreId")));
	// membreService.delete(membre);
	// return "redirect:/supprimerMembre";
	//
	// }
	//
	// @RequestMapping(value = "/editmembre", method = RequestMethod.GET)
	// private String editMembre(HttpServletRequest request, Model model) {
	// Membre membre =
	// membreService.get(Integer.parseInt(request.getParameter("idMembre")));
	// model.addAttribute("edit", membre);
	// return "admineditmembre";
	//
	// }
	//
	// @RequestMapping(value = "/editmembre", method = RequestMethod.POST)
	// private String editMembre(@ModelAttribute("edit") Membre membre,
	// @RequestParam(value = "idMembre") int idMembre) {
	// membre.setId(idMembre);
	// membreService.save(membre);
	// return "redirect:/supprimerMembre";
	//
	// }
}
