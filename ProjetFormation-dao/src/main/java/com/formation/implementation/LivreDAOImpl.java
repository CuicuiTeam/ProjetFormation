
package com.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.dao.LivreDAO;
import com.formation.entities.Auteur;
import com.formation.entities.Categorie;
import com.formation.entities.Livre;

public class LivreDAOImpl extends DAOPrincipalImpl<Livre> implements LivreDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Livre> getLivreByCat(Categorie cat) {
		// TODO Auto-generated method stub
		return (List<Livre>) sessionFactory.getCurrentSession().createQuery("FROM Livre L WHERE L.categorie = :cat")
				.setParameter("cat", cat);
	}

	@Override
	public List<Livre> getPeriodiques() {
		// TODO Auto-generated method stub
		return (List<Livre>) sessionFactory.getCurrentSession().createQuery("FROM Livre L WHERE L.isPeriodic = 1");
	}

	@Override
	public List<Livre> getLivreByAuteur(Auteur auteur) {
		// TODO Auto-generated method stub
		return (List<Livre>) sessionFactory.getCurrentSession()
				.createQuery("FROM Livre L WHERE L.auteur =:auteur ORDER BY L.titre").setParameter("auteur", auteur);
	}

	@Override
	public List<Livre> getLivreByRecherche(String recherche) {
		// TODO Auto-generated method stub
		return (List<Livre>) sessionFactory.getCurrentSession()
				.createQuery("FROM Livre L WHERE L.titre LIKE :recherche OR L.description LIKE :recherche")
				.setParameter("recherche", "%" + recherche + "%");
	}

	@Override
	public List<Livre> getLivreRecommandes() {
		// TODO Auto-generated method stub
		return (List<Livre>) sessionFactory.getCurrentSession().createQuery("FROM Livre L WHERE L.isPopular = 1");
	}

}
