package com.formation.dao;

import java.util.List;

import com.formation.entities.Auteur;

public interface AuteurDAO extends DAOPrincipal<Auteur> {

	public Auteur getAuteurByNom(String nom);
	public Auteur getAuteurBySlug(String slug);
	public List<Auteur> getAuteurAll();

}
