package com.victortylikov.spring.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@Column(name = "id_role")
	private Integer idRole;

	@Column(name = "role")
	private String role;
	
	@ManyToMany
	@JoinTable(name = "user_role", 
	      joinColumns = @JoinColumn(name = "id_role"), 
	      inverseJoinColumns = @JoinColumn(name = "id_user"))
	private Set<User> users = new HashSet<User>();

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
