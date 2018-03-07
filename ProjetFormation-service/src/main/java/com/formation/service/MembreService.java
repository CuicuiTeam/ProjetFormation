package com.formation.service;

import com.formation.entities.Membre;

public interface MembreService {
	
	public Membre get(int id);
	
	public Membre findByEmail(String email);
	
	public Membre identification(String email, String password);

	public void save(Membre m);
	
	public void delete(Membre m);

	public String cryptageMdp(Membre membre);

}
