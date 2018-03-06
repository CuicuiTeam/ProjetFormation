package com.formation.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.BibliothequeDAO;
import com.formation.entities.Bibliotheque;
import com.formation.service.BibliothequeService;

@Service
public class BibliothequeServiceImpl implements BibliothequeService {

	@Autowired
	private BibliothequeDAO bibliothequeDAO;
	
	@Override
	public List<Bibliotheque> getAll() {
		return bibliothequeDAO.getAll();
	} 
	
}
