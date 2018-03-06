package com.formation.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.MembreDAO;
import com.formation.entities.Membre;
import com.formation.service.MembreService;

@Service
public class MembreServiceImpl implements MembreService{
	
	@Autowired
	private MembreDAO membreDAO;
	
	@Override
	public Membre identification(String email, String password) {
		return membreDAO.identification(email, password);
	}

	@Override
	public void save(Membre m) {
		// TODO Auto-generated method stub
		membreDAO.save(m);
	}

}
