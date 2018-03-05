package com.formation.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.formation.service.LivreService;


@Controller
public class LivreControlleur {

	@Autowired
	private LivreService livreService;


}
