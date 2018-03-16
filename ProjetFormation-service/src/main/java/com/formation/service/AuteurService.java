package com.formation.service;

import java.util.List;

import com.formation.entities.Auteur;

public interface AuteurService {

	public Auteur getAuteurByNom(String nom);
	public Auteur getAuteurBySlug(String slug);
	public List<Auteur> getAll();
	public List<Auteur> getAuteurAll();

	public List<Auteur> getAuteursById(List<Integer> ids);

	public Auteur get(int id);

}
