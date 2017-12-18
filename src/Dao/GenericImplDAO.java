package Dao;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class GenericImplDAO<T> implements GenericDAO<T> {
  
	protected EntityManager em;
	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T entity) {
		this.em.persist(entity);
		return entity;
	}

	@Override
	public void remove(Object id) {
	
		
	}

	@Override
	public T findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getTotalResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
