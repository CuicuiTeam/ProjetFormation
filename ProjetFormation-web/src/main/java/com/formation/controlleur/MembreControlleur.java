package com.formation.controlleur;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.MembreDTO;
import com.formation.entities.Inscription;
import com.formation.entities.Membre;
import com.formation.service.InscriptionService;
import com.formation.service.MembreService;

@RestController
public class MembreControlleur {

	@Autowired
	private MembreService membreService;
	
	@Autowired
	private InscriptionService inscriptionService;
	
	/////////////////////////////////////////////////////////////////////////////
	
	@PutMapping(value = "/admin/membre")
	public void ajoutMembre(@RequestBody MembreDTO membreDto) {
		
		Membre newMembre = new Membre(membreDto.getNom(), membreDto.getPrenom(), membreDto.getPassword(), membreDto.getAdresse(), membreDto.getVille(), membreDto.getCodePostal(), membreDto.getTelephone(), membreDto.getEmail(), membreDto.isAdmin());
		newMembre.setInscriptions(inscriptionService.getInscriptionById(membreDto.getInscriptionsId()));
		membreService.save(newMembre);
	}
	
	@GetMapping(value = "/admin/membre")
	public List<MembreDTO> listerMembres() {
		List<MembreDTO> resultats = new ArrayList<MembreDTO>();
		List<Membre> listeMembres = membreService.getAll();
		
		
		listeMembres.forEach(membre -> {			
			MembreDTO membreDto = new MembreDTO(membre.getNom(), membre.getPrenom(), membre.getPassword(), membre.getAdresse(), membre.getVille(), membre.getCodePostal(), membre.getTelephone(), membre.getEmail(), membre.isAdmin());
			List<Integer> inscriptionIds = new ArrayList<Integer>();
			
			membre.getInscriptions().forEach(inscription -> inscriptionIds.add(inscription.getId()));
			membreDto.setInscriptionsId(inscriptionIds);
			membreDto.setId(membre.getId());
			resultats.add(membreDto);
		});
		
		return resultats;
	}
	
	@PostMapping(value = "/admin/membre/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	   public void updateMembre(@RequestBody MembreDTO membreDto, @PathVariable(value="id") int id){

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
	   }
	
	@DeleteMapping(value="/admin/membre/{id}")
    private void deleteMembre(@PathVariable(value="id") int id) {
        membreService.delete(membreService.get(id));
    }
	
   /////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/admin/inscription", method = RequestMethod.GET)
	private String ajoutMembre(Model model) {

		Membre newMembre = new Membre();
		model.addAttribute("newMembre", newMembre);
		return "inscription";
	}

	@RequestMapping(value = "/admin/inscription", method = RequestMethod.POST)
	private String ajoutMembre(@ModelAttribute("newMembre") Membre newMembre, Model model) {
		newMembre.setPassword(membreService.cryptageMdp(newMembre.getPassword()));
		if (membreService.findByEmail(newMembre.getEmail()) != null) {
			model.addAttribute("msgErreur", "Cet email est déjà utilisé");
			newMembre.setPassword("");
			return "inscription";
		} else {
			membreService.save(newMembre);
			return "redirect:/";
		}
	}

//	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
//	private String connexionMembre(Model model) {
//
//		Membre newMembre = new Membre();
//		model.addAttribute("login", newMembre);
//		return "connexion";
//	}
//
//	@RequestMapping(value = "/connexioncheck", method = RequestMethod.POST)
//	private String connexionMembre(@ModelAttribute("login") Membre newMembre, Model model, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		try {
//			Membre membre = membreService.identification(newMembre.getEmail(), newMembre.getPassword());
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(membre != null) {
//			session.setAttribute("user", membre);
//			return "redirect:/";
//		} else {
//			model.addAttribute("msgErreur", "Veuillez saisir un identifiant et un mot de passe valide");
//			return "connexion";
//		}
//	}

	@RequestMapping(value = "/supprimerMembre", method = RequestMethod.GET)
	private String supprMembre(Model model) {

		model.addAttribute("membres", membreService.getAll());
		return "adminmembresuppr";
	}

	@RequestMapping(value = "/supprimerMembre", method = RequestMethod.POST)
	private String supprMembre(HttpServletRequest request) {
		Membre membre = membreService.get(Integer.parseInt(request.getParameter("membreId")));
		membreService.delete(membre);
		return "redirect:/supprimerMembre";

	}

	@RequestMapping(value = "/editmembre", method = RequestMethod.GET)
	private String editMembre(HttpServletRequest request, Model model) {
		Membre membre = membreService.get(Integer.parseInt(request.getParameter("idMembre")));
		model.addAttribute("edit", membre);
		return "admineditmembre";

	}

	@RequestMapping(value = "/editmembre", method = RequestMethod.POST)
	private String editMembre(@ModelAttribute("edit") Membre membre, @RequestParam(value = "idMembre") int idMembre) {
		membre.setId(idMembre);
		membreService.save(membre);
		return "redirect:/supprimerMembre";

	}
}
