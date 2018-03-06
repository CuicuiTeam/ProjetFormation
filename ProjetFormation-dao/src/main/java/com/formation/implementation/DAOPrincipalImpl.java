
package com.formation.implementation;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.dao.DAOPrincipal;

public abstract class DAOPrincipalImpl<T> implements DAOPrincipal<T>{
	
	private Class<T> type;
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	public DAOPrincipalImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}
	@Override
	public void save(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public List<T> getAll() {
		return (List<T>)sessionFactory.getCurrentSession().createQuery("from "+ type.getName()).getResultList();
	}

	@Override
	public T get(int id) {
		return (T)sessionFactory.getCurrentSession().get(type, id);
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
