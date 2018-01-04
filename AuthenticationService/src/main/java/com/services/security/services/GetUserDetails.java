package com.services.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.services.security.persistence.DummyPersistenceObjectForUser;
import com.services.security.pojos.User;

@Service
public class GetUserDetails implements UserDetailsService{

	@Autowired
	DummyPersistenceObjectForUser dummyUserPersistence;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = dummyUserPersistence.findUserByUsername(username);
		if(user!=null) {
		String[] roles = user.getAuthorities();
		
		return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword())
				.roles(roles).build();
		}
		return null;
	}
		

}
