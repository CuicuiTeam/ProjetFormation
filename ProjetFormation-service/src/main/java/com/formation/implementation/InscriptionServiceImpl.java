package com.formation.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.dao.InscriptionDAO;
import com.formation.entities.Exemplaire;
import com.formation.entities.Inscription;
import com.formation.service.InscriptionService;

public class InscriptionServiceImpl implements InscriptionService {

	@Autowired
	private InscriptionDAO inscriptionDao;
	
	@Override
	public Inscription get(int id) {
		return inscriptionDao.get(id);
	}
	
	@Override
	public void save(Inscription inscription) {
		inscriptionDao.save(inscription);
	}
	
	@Override
	public void delete (Inscription inscription) {
		inscriptionDao.delete(inscription);
	}
	
	@Override
	public List<Inscription> getAll() {
		return inscriptionDao.getAll();
	}
	
	@Override
	public List<Inscription> getInscriptionById(List<Integer> ids) {
		return inscriptionDao.getAll().stream().filter(a -> ids.contains(a.getId())).collect(Collectors.toList());
	}
}
