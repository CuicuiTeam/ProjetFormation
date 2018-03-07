
package com.formation.implementation;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.MembreDAO;
import com.formation.entities.Membre;

@Repository
@Transactional
public class MembreDAOImpl extends DAOPrincipalImpl<Membre> implements MembreDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Membre identification(String email, String password) {
		return (Membre) sessionFactory.getCurrentSession()
				.createQuery("FROM Membre m WHERE m.email = :email AND m.password = :password")
				.setParameter("email", email).setParameter("password", password).getSingleResult();
	}

	@Override
	public void save(Membre m) {

		sessionFactory.getCurrentSession().saveOrUpdate(m);
	}

	@Override
	public boolean getMembreByMail(String email) {
		if (sessionFactory.getCurrentSession().createQuery("FROM Membre m WHERE m.email = :email").setParameter("email",
				email) == null) {
			return false;
		} else {
			return true;
		}
	}
}
