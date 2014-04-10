package com.victortylikov.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.victortylikov.spring.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> findAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("select distinct u from User u left join fetch u.roles r").list();
	}

	@Override
	public void addUser(User user) {
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
	/*	Query query=sessionFactory.getCurrentSession().createQuery("select distinct u from User u u.login = :login");
		query.setParameter("login", login);*/
		User query=new User();
		query.setIdUser(1);
		query.setLogin(login);
		query.setPassword("test");
		query.setEmail("test@mail.ru");
		return (User) query;
	}

}
