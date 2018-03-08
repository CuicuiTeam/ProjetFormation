
package com.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.LivreDAO;
import com.formation.entities.Auteur;
import com.formation.entities.Categorie;
import com.formation.entities.Livre;

@Repository
@Transactional
public class LivreDAOImpl extends DAOPrincipalImpl<Livre> implements LivreDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Livre> getLivreByCat(Categorie cat) {
		// TODO Auto-generated method stub
		return (List<Livre>) sessionFactory.getCurrentSession().createQuery("FROM Livre L WHERE L.categorie = :cat")
				.setParameter("cat", cat).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Livre> getPeriodiques() {
		// TODO Auto-generated method stub
		return (List<Livre>) sessionFactory.getCurrentSession().createQuery("FROM Livre L WHERE L.isPeriodic = 1").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Livre> getLivreByAuteur(Auteur auteur) {
		// TODO Auto-generated method stub
		return (List<Livre>) sessionFactory.getCurrentSession()
				.createQuery("SELECT L FROM Livre L JOIN L.auteurs a WHERE a.id =:idAuteur").setParameter("idAuteur", auteur.getId()).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Livre> getLivreByRecherche(String recherche) {
		// TODO Auto-generated method stub
		return (List<Livre>) sessionFactory.getCurrentSession()
				.createQuery("FROM Livre L WHERE L.titre LIKE :recherche OR L.description LIKE :recherche")
				.setParameter("recherche", "%" + recherche + "%").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Livre> getLivreRecommandes() {
		// TODO Auto-generated method stub
		return (List<Livre>) sessionFactory.getCurrentSession().createQuery("FROM Livre L WHERE L.isPopular = 1").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void save(Livre livre) {
		sessionFactory.getCurrentSession().saveOrUpdate(livre);
	}

}
