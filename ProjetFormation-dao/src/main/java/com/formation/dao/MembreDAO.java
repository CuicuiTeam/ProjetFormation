
package com.formation.dao;

import java.util.List;

import org.hibernate.Hibernate;

import com.formation.entities.Membre;

public interface MembreDAO extends DAOPrincipal<Membre> {

	public Membre identification(String email, String password);

	public Membre findMembreByEmail(String email);

	
	
	
	
	
}
