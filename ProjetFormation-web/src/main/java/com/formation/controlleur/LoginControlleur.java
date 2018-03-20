package com.formation.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.exception.ServiceException;
import com.formation.service.MembreService;
import com.formation.utils.ControllerConstants;
import com.formation.utils.Resultat;
import com.formation.viewmodel.IdentifiantsVM;

@RestController
public class LoginControlleur {

	@Autowired
	private MembreService membreService;

	
	@PostMapping(value="/connexion", consumes=  MediaType.APPLICATION_JSON_VALUE)
	private Resultat connexionMembre(@RequestBody IdentifiantsVM identifiants) {
		Resultat resultat = new Resultat();
		try {
			membreService.identification(identifiants.getEmail(), identifiants.getPassword());
			
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