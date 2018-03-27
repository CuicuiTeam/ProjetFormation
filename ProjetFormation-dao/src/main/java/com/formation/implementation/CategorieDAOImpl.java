package com.formation.implementation;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.CategorieDAO;
import com.formation.entities.Auteur;
import com.formation.entities.Categorie;

@Repository
@Transactional
public class CategorieDAOImpl extends DAOPrincipalImpl<Categorie> implements CategorieDAO {

@Autowired
private SessionFactory sessionFactory;

@SuppressWarnings("unchecked")
public Categorie getCategorieByNom(String nom) {
	return (Categorie)sessionFactory.getCurrentSession().createQuery("FROM Categorie C WHERE C.nom = :nom ORDER BY C.nom").setParameter("nom", nom).getResultList().stream().findFirst().orElse(null);
}

@SuppressWarnings("unchecked")
public List<Categorie> getAll() {
	List<Categorie> categories =  (List<Categorie>) sessionFactory.getCurrentSession().createQuery("SELECT C FROM Categorie C ORDER BY C.nom ASC").getResultList();
	return categories;
	}
	
}
