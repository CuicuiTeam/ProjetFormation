package com.formation.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.LivreDAO;
import com.formation.entities.Auteur;
import com.formation.entities.Categorie;
import com.formation.entities.Livre;
import com.formation.service.LivreService;

@Service
public class LivreServiceImpl implements LivreService {

	@Autowired
	private LivreDAO livreDAO;

	@Override
	public List<Livre> getLivreByCat(Categorie cat) {
		// TODO Auto-generated method stub
		return reductionDescription(livreDAO.getLivreByCat(cat));
	}

	@Override
	public List<Livre> getPeriodiques() {
		// TODO Auto-generated method stub
		return reductionDescription(livreDAO.getPeriodiques());
	}

	@Override
	public List<Livre> getLivreByAuteur(Auteur auteur) {
		// TODO Auto-generated method stub
		return reductionDescription(livreDAO.getLivreByAuteur(auteur));
	}

	@Override
	public List<Livre> getLivreByRecherche(String recherche)  {
		// TODO Auto-generated method stub
		return reductionDescription(livreDAO.getLivreByRecherche(recherche));
	}

	@Override
	public List<Livre> getLivreRecommandes() {
		// TODO Auto-generated method stub
		return reductionDescription(livreDAO.getLivreRecommandes());
	}

	@Override
	public void save(Livre livre) {
		// TODO Auto-generated method stub
		livreDAO.save(livre);
	}
	
	private List<Livre> reductionDescription(List<Livre> liste) {
		liste.forEach((l) ->{
			if (l.getDescription().length() > 250) 
		l.setDescription(l.getDescription().substring(0, 250) + " ...");
		});
		
		return liste;	
		
	}

}
