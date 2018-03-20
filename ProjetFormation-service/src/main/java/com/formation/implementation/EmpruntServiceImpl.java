package com.formation.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.formation.dao.EmpruntDAO;
import com.formation.entities.Emprunt;
import com.formation.service.EmpruntService;
@Service
@Transactional
public class EmpruntServiceImpl implements EmpruntService{
	
	@Autowired
	private EmpruntDAO empruntDao;

	@Override
	public Emprunt get(int id)  throws Exception{
		return empruntDao.get(id);
	}

	@Override
	public void save(Emprunt emprunt)  throws Exception{
		empruntDao.save(emprunt);
	}

	@Override
	public void delete(Emprunt emprunt)  throws Exception{
		empruntDao.delete(emprunt);
	}

	@Override
	public List<Emprunt> getAll()  throws Exception{
		return empruntDao.getAll();
	}

}
