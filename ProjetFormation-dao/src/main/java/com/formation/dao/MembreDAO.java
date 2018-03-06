
package com.formation.dao;

import com.formation.entities.Membre;

public interface MembreDAO extends DAOPrincipal<Membre> {

	public Membre identification(String email, String password);

	public void save(Membre m);
}
