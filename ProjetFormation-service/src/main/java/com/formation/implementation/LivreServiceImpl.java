package com.formation.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.LivreDAO;
import com.formation.entities.Auteur;
import com.formation.entities.Categorie;
import com.formation.entities.Livre;
import com.formation.service.LivreService;

@Service
@Transactional
public class LivreServiceImpl implements LivreService {

	@Autowired
	private LivreDAO livreDAO;

	@Override
	public List<Livre> getLivreByCat(Categorie cat) throws Exception {
		// TODO Auto-generated method stub
		return livreDAO.getLivreByCat(cat);
	}

	@Override
	public List<Livre> getPeriodiques() throws Exception {
		// TODO Auto-generated method stub
		return livreDAO.getPeriodiques();
	}

	@Override
	public List<Livre> getLivreByAuteur(Auteur auteur)  throws Exception{
		// TODO Auto-generated method stub
		return livreDAO.getLivreByAuteur(auteur);
	}

	@Override
	public List<Livre> getLivreByRecherche(String recherche)  throws Exception {
		// TODO Auto-generated method stub
		return livreDAO.getLivreByRecherche(recherche);
	}

	@Override
	public List<Livre> getLivreRecommandes() throws Exception {
		// TODO Auto-generated method stub
		return livreDAO.getLivreRecommandes();
	}

	@Override
	public void save(Livre livre) throws Exception {
		// TODO Auto-generated method stub
		// livre.setEditeur(editeurDAO.get(livre.getEditeur().getId()));
		livreDAO.save(livre);
	}

//	private List<Livre> reductionDescription(List<Livre> liste) {
//		liste.forEach((l) ->{
//			if (l.getDescription().length() > 250) 
//				l.setDescription(l.getDescription().substring(0, 250) + " ...");
//		});
//
//		return liste;	
//
//	}

	@Override
	public void delete(Livre livre) throws Exception {
		// TODO Auto-generated method stub
		livreDAO.delete(livre);
	}

	@Override
	public List<Livre> getAll()  throws Exception{
		// TODO Auto-generated method stub
		return livreDAO.getAll();
	}

	@Override
	public Livre get(int id)  throws Exception{
		// TODO Auto-generated method stub
		return livreDAO.get(id);
	}

}
