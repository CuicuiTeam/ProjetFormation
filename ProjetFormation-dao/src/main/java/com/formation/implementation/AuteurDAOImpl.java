package com.formation.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.AuteurDAO;
import com.formation.entities.Auteur;

@Repository
@Transactional
public class AuteurDAOImpl extends DAOPrincipalImpl<Auteur> implements AuteurDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Auteur getAuteurByNom(String nom) {
		return (Auteur) sessionFactory.getCurrentSession().createQuery("FROM Auteur A WHERE A.nom = :nom ")
				.setParameter("nom", nom).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Auteur> getAuteurAll() {
		List<Auteur> auteurs =  (List<Auteur>) sessionFactory.getCurrentSession().createQuery("SELECT A FROM Auteur A ORDER BY A.nom ASC").getResultList();
//		for (Auteur auteur : auteurs) {
//			Hibernate.initialize(auteur.getLivres());
//		}
		return auteurs;
 	}

	
}
