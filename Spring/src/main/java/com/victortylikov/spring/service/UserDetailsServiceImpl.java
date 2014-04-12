package com.victortylikov.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victortylikov.spring.dao.UserDao;
import com.victortylikov.spring.domain.Role;

@Service  
@Transactional(readOnly=true) 
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		com.victortylikov.spring.domain.User user=userDao.getUserByName(login);
		
/*		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    for (Role role : user.getRoles()) {
	      authorities.add(new GrantedAuthorityImpl(role.getRole()));
	    }*/
		
		return new AuthenticationUserDetails(user);
	}



}
