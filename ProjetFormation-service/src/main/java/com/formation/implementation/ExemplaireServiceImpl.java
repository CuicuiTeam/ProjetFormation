package com.formation.implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dao.ExemplaireDAO;
import com.formation.entities.Exemplaire;
import com.formation.service.ExemplaireService;
@Service
@Transactional
public class ExemplaireServiceImpl implements ExemplaireService{
	
	@Autowired
	private ExemplaireDAO exemplaireDao;

	@Override
	public Exemplaire get(int id)  throws Exception{
		return exemplaireDao.get(id);
	}

	@Override
	public void save(Exemplaire exemplaire) throws Exception {
		exemplaireDao.save(exemplaire);
	}

	@Override
	public void delete(Exemplaire exemplaire)  throws Exception{
		exemplaireDao.delete(exemplaire);
	}

	@Override
	public List<Exemplaire> getAll()  throws Exception{
		return exemplaireDao.getAll();
	}


	@Override
	public List<Exemplaire> getExemplaireById(List<Integer> ids)  throws Exception{
		return exemplaireDao.getAll().stream().filter(a -> ids.contains(a.getId())).collect(Collectors.toList());
	}

}
