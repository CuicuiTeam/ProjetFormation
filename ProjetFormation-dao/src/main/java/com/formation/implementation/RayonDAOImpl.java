
package com.formation.implementation;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.RayonDAO;
import com.formation.entities.Rayon;

@Repository
@Transactional
public class RayonDAOImpl extends DAOPrincipalImpl<Rayon> implements RayonDAO {
	
	@Override
	public List<Rayon> getAll() {
		List<Rayon> rayons = super.getAll();
		for (Rayon rayon : rayons) {
			Hibernate.initialize(rayon.getBibliotheque());
			Hibernate.initialize(rayon.getExemplaires());
		}

		return rayons;

	}

}
