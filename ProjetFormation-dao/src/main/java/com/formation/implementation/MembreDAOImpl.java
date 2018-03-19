
package com.formation.implementation;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.MembreDAO;
import com.formation.entities.Auteur;
import com.formation.entities.Categorie;
import com.formation.entities.Livre;
import com.formation.entities.Membre;

@Repository
@Transactional
public class MembreDAOImpl extends DAOPrincipalImpl<Membre> implements MembreDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Membre identification(String email, String password) {
		return (Membre) sessionFactory.getCurrentSession()
				.createQuery("FROM Membre m WHERE m.email = :email AND m.password = :password")
				.setParameter("email", email).setParameter("password", password).getResultList().stream().findFirst()
				.orElse(null);
	}

	@Override
	public void save(Membre m) {

		sessionFactory.getCurrentSession().saveOrUpdate(m);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Membre findMembreByEmail(String email) {
		return (Membre) sessionFactory.getCurrentSession().createQuery("FROM Membre m WHERE m.email = :email")
				.setParameter("email", email).getResultList().stream().findFirst().orElse(null);
	}

	@Override
	public List<Membre> getAll() {
		List<Membre> membres = super.getAll();
		for (Membre membre : membres) {
			Hibernate.initialize(membre.getInscriptions());
			Hibernate.initialize(membre.getAuthorities());
			Hibernate.initialize(membre.getExemplaires());
			Hibernate.initialize(membre.getPaniers());
			Hibernate.initialize(membre.getEmprunts());
		}

		return membres;

	}

}
