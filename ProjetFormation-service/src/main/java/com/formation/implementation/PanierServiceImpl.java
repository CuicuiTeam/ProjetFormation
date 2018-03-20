package com.formation.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.PanierDAO;
import com.formation.entities.Panier;
import com.formation.service.PanierService;

@Service
@Transactional
public class PanierServiceImpl implements PanierService {
	
	@Autowired
	private PanierDAO panierDao;

	@Override
	public Panier get(int id)  throws Exception{
		return panierDao.get(id);
	}

	@Override
	public void save(Panier panier)  throws Exception{
		panierDao.save(panier);
	}

	@Override
	public void delete(Panier panier)  throws Exception{
		panierDao.delete(panier);
	}

	@Override
	public List<Panier> getAll()  throws Exception{
		return panierDao.getAll();
	}
}
