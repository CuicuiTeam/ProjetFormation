package com.formation.implementation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.entities.Membre;
import com.formation.entities.UserProfile;
import com.formation.service.MembreService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private MembreService membreService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Membre membre = membreService.findByEmail(email);
		logger.info("User : {}", membre);
		if(membre == null) {
			logger.info("User not found");
			throw new UsernameNotFoundException("Email not found");
		}
		return new User(membre.getEmail(), membre.getPassword(), true, true, true, true, getGrantedAuthorities(membre));
	}

	private List<GrantedAuthority> getGrantedAuthorities(Membre membre){
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for (UserProfile userProfile: membre.getUserProfiles()) {
			logger.info("UserProfile : {}", userProfile);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
		}
		logger.info("authorities : {}", authorities);
		return authorities;
	}
}
