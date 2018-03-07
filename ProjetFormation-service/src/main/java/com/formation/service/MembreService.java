package com.formation.service;

import com.formation.entities.Membre;

public interface MembreService {
	
	public Membre identification(String email, String password);

	public void save(Membre m);

	public String cryptageMdp(Membre membre);

	public boolean getMembreByMail(String email);

}
