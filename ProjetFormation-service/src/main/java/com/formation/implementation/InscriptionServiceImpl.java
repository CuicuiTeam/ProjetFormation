package com.formation.implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.InscriptionDAO;
import com.formation.entities.Inscription;
import com.formation.service.InscriptionService;
@Service
@Transactional
public class InscriptionServiceImpl implements InscriptionService {

	@Autowired
	private InscriptionDAO inscriptionDao;
	
	@Override
	public Inscription get(int id)  throws Exception{
		return inscriptionDao.get(id);
	}
	
	@Override
	public void save(Inscription inscription)  throws Exception{
		inscriptionDao.save(inscription);
	}
	
	@Override
	public void delete (Inscription inscription)  throws Exception{
		inscriptionDao.delete(inscription);
	}
	
	@Override
	public List<Inscription> getAll()  throws Exception{
		return inscriptionDao.getAll();
	}
	
	@Override
	public List<Inscription> getInscriptionById(List<Integer> ids)  throws Exception{
		return inscriptionDao.getAll().stream().filter(a -> ids.contains(a.getId())).collect(Collectors.toList());
	}
}
