package com.formation.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.ExemplaireDAO;
import com.formation.entities.Exemplaire;
import com.formation.service.ExemplaireService;

@Service
@Transactional
public class ExemplaireServiceImpl implements ExemplaireService{
	
	@Autowired
	private ExemplaireDAO exemplaireDao;

	@Override
	public Exemplaire get(int id) {
		return exemplaireDao.get(id);
	}

	@Override
	public void save(Exemplaire exemplaire) {
		exemplaireDao.save(exemplaire);
	}

	@Override
	public void delete(Exemplaire exemplaire) {
		exemplaireDao.delete(exemplaire);
	}

	@Override
	public List<Exemplaire> getAll() {
		return exemplaireDao.getAll();
	}

}
