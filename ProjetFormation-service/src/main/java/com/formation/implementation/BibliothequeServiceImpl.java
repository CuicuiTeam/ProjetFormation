package com.formation.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.BibliothequeDAO;
import com.formation.entities.Bibliotheque;
import com.formation.service.BibliothequeService;

@Service
@Transactional
public class BibliothequeServiceImpl implements BibliothequeService {

	@Autowired
	private BibliothequeDAO bibliothequeDAO;
	
	@Override
	public List<Bibliotheque> getAll()  throws Exception{
		return bibliothequeDAO.getAll();
	}

	@Override
	public void save(Bibliotheque biblio)  throws Exception{
		// TODO Auto-generated method stub
		bibliothequeDAO.save(biblio);
	}

	@Override
	public Bibliotheque get(int id)  throws Exception{
		// TODO Auto-generated method stub
		return bibliothequeDAO.get(id);
	}

	@Override
	public void delete(Bibliotheque biblio)  throws Exception{
		// TODO Auto-generated method stub
		bibliothequeDAO.delete(biblio);

	} 
	
	
	


}
