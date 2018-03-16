package com.formation.implementation;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.MembreDAO;
import com.formation.entities.Membre;
import com.formation.exception.ErrorConstants;
import com.formation.exception.ServiceException;
import com.formation.service.MembreService;

@Service
@Transactional
public class MembreServiceImpl implements MembreService{
	
	@Autowired
	private MembreDAO membreDAO;
	
	@Override
	public Membre identification(String email, String password) throws Exception{
		if (membreDAO.identification(email, cryptageMdp(password)) != null)
				throw new ServiceException(ErrorConstants.ACCOUNT_NOT_EXISTING);
		else
			return membreDAO.findMembreByEmail(email);
	}

	@Override
	public void save(Membre m) {
		membreDAO.save(m);
	}

	public String cryptageMdp(String password) {
		String generatedPassword = null;
	       try {
	           MessageDigest md = MessageDigest.getInstance("SHA-512");
	           byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
	           StringBuilder sb = new StringBuilder();
	           for (int i = 0; i < bytes.length; i++) {
	               sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	           }
	           generatedPassword = sb.toString();
	       } catch (NoSuchAlgorithmException e) {
	           System.out.println(e);
	       }
	       return generatedPassword;

	}

	@Override
	public Membre get(int id) {
		return membreDAO.get(id);
	}

	@Override
	public Membre findByEmail(String email) {
		return membreDAO.findMembreByEmail(email);
	}

	@Override
	public void delete(Membre m) {
		membreDAO.delete(m);
	}

	@Override
	public List<Membre> getAll() {
		return membreDAO.getAll();
	}

}
