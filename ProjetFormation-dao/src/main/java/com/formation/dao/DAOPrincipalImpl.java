package com.formation.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DAOPrincipalImpl<T> implements DAOPrincipal<T>{
	
	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> type;
	@Override
	public void save(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public List<T> getAll() {
		return (List<T>)sessionFactory.getCurrentSession().createQuery("from "+ type.getClass().getComponentType()).getResultList();
	}

	@Override
	public T get(int id) {
		return (T)sessionFactory.getCurrentSession().get(this.getClass(), id);
	}

	@Override
	public void delete(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
