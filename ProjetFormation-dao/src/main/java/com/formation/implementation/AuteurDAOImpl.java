package com.formation.implementation;

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
		// TODO Auto-generated method stub
		return (Auteur) sessionFactory.getCurrentSession().createQuery("FROM Auteur A WHERE A.nom = :nom");
	}

}
