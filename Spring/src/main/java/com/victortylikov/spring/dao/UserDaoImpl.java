package com.victortylikov.spring.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.victortylikov.spring.domain.Role;
import com.victortylikov.spring.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public List<User> findAllUsers() {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"select distinct u from User u left join fetch u.roles r")
				.list();
	}

	@Override
	public void addUser(User user) {
		Role role=(Role)sessionFactory.getCurrentSession().createQuery("from Role r where r.idRole=1").uniqueResult();
		System.out.println(role.getRole());
		Set<Role> roles=new HashSet<Role>();
		roles.add(role);
		user.setRoles(roles);
	//	sessionFactory.getCurrentSession().save(role);
		sessionFactory.getCurrentSession().save(user);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User getUserByName(String login) {
		List<User> users = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select distinct u from User u left join fetch u.roles r")
				.list();
		User user = null;
		for (User u : users) {
			if (u.getLogin().equals(login)) {
				user = u;
			}
		}
		return user;
	}

}
