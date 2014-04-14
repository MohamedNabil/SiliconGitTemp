package com.siliconnile.dao.impl;

import java.util.Collection;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.pearlox.framework.dao.BasicDao;
import com.pearlox.framework.domain.BasicObject;

/**
 * User: Andrew Date: 3/27/13
 *
 * The purpose of this class is to fix issue with new transaction creation (instead of transaction re-use) on read-only
 * operations like findAll() and findById(). This issue is introduced in com.pearlox.framework.
 *
 * @param <T> the generic type
 */
public class BasicJpaDao<T extends BasicObject> implements BasicDao<T>  {
	
	protected EntityManager entityManager;

	protected Class<T> type = null;


	public BasicJpaDao(final Class<T> aType) {
		this.type = aType;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	@Transactional
	public void delete(T entity) throws Exception {
		this.getEntityManager().remove(entity);

	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public Collection<T> findAll() throws Exception {
		String selectQuery = "Select obj from " + this.type.getSimpleName()
				+ " obj ORDER BY obj.id";
		Query query = this.getEntityManager().createQuery(selectQuery);
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public T findById(Long id) throws Exception {
		return this.entityManager.find(this.type, id);
	}


	@Override
	@Transactional
	public T saveOrUpdate(T entity) throws Exception {
		try {
			if (entity.getId() == null)
				this.entityManager.persist(entity);
			else
				entity = this.entityManager.merge(entity);
			entityManager.flush();
			return entity;
		} catch (EntityExistsException ex) {
			throw new RuntimeException(ex);
		}

	}
}
