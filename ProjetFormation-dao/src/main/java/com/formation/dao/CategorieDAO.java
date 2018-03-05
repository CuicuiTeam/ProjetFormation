package com.formation.dao;

import com.formation.entities.Categorie;

public interface CategorieDAO extends DAOPrincipal<Categorie> {

	public Categorie getCategorieByNom(String nom);
}
