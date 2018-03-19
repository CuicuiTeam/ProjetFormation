package com.formation.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.dao.MembreDAO;
import com.formation.entities.Membre;
import com.formation.service.MembreService;

@Service
@Transactional
public class MembreServiceImpl implements MembreService, UserDetailsService{
	
	@Autowired
	private MembreDAO membreDAO;
	
	@Override
	public Membre identification(String email, String password) {
		return membreDAO.identification(email, cryptageMdp(password));
	}

	@Override
	public void save(Membre m) {
		membreDAO.save(m);
	}

	public String cryptageMdp(String password) {
		return new BCryptPasswordEncoder().encode(password);

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

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Membre membre = membreDAO.findMembreByEmail(email);
		UserBuilder builder = null;
		if(membre != null) {
			builder = User.withUsername(email);
			builder.disabled(false);
			builder.password(membre.getPassword());
			String[] authorities = membre.getAuthorities().stream().map(a -> a.getAuthority()).toArray(String[]::new);
			
			builder.authorities(authorities);
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}

	@Override
	public List<Membre> getAll() {
		return membreDAO.getAll();
	}
	
	

}
