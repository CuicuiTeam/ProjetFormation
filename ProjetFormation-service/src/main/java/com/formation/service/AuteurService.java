package com.formation.service;

import java.util.List;

import com.formation.entities.Auteur;
import com.formation.entities.Bibliotheque;

public interface AuteurService {

	public Auteur getAuteurByNom(String nom);
	public Auteur getAuteurBySlug(String slug);
	public List<Auteur> getAll();
	public List<Auteur> getAuteurAll();

}
