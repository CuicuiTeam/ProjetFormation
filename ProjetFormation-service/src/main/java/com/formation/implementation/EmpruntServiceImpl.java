package com.formation.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.EmpruntDAO;
import com.formation.entities.Emprunt;
import com.formation.service.EmpruntService;

@Service
@Transactional
public class EmpruntServiceImpl implements EmpruntService{
	
	@Autowired
	private EmpruntDAO empruntDao;

	@Override
	public Emprunt get(int id) {
		return empruntDao.get(id);
	}

	@Override
	public void save(Emprunt emprunt) {
		empruntDao.save(emprunt);
	}

	@Override
	public void delete(Emprunt emprunt) {
		empruntDao.delete(emprunt);
	}

	@Override
	public List<Emprunt> getAll() {
		return empruntDao.getAll();
	}

}
