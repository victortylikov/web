package com.victortylikov.spring.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.victortylikov.spring.domain.Role;

@Component
public class AuthenticationUserDetails implements UserDetails{

	private Integer idUser;
	private String login;
	private String password;
	private String email;
	private Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
	private Set<Role> roles=new HashSet<Role>();
	private boolean enabled=true;
	
	public AuthenticationUserDetails(com.victortylikov.spring.domain.User user) {
		this.idUser=user.getIdUser();
		this.login=user.getLogin();
		this.password=user.getPassword();
		this.email=user.getEmail();
		this.roles=user.getRoles();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		for (Role role : roles) {
			grantedAuthorities.add(new GrantedAuthorityImpl(role.getRole()));
		    }
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}
	
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

}
