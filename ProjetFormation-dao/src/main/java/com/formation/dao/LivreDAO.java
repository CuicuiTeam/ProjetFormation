
package com.formation.dao;

import java.util.List;

import com.formation.entities.Auteur;
import com.formation.entities.Categorie;
import com.formation.entities.Livre;

public interface LivreDAO extends DAOPrincipal<Livre> {

	public List<Livre> getLivreByCat(Categorie cat);

	public List<Livre> getPeriodiques();

	public List<Livre> getLivreByAuteur(Auteur auteur);

	public List<Livre> getLivreByRecherche(String recherche);

	public List<Livre> getLivreRecommandes();

}
