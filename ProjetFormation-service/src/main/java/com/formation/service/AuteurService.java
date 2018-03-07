package com.formation.service;

import com.formation.entities.Auteur;

public interface AuteurService {

	public Auteur getAuteurByNom(String nom);
	public Auteur getAuteurBySlug(String slug);

}
