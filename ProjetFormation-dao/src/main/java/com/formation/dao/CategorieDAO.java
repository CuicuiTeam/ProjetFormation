package com.formation.dao;

import java.util.List;

import com.formation.entities.Categorie;

public interface CategorieDAO extends DAOPrincipal<Categorie> {

	public Categorie getCategorieByNom(String nom);
	
	public List<Categorie> getAll();
}
