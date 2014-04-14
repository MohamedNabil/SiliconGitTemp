package com.siliconnile.dao.impl;

import java.util.Collection;

import javax.persistence.Query;

import com.pearlox.framework.dao.impl.BasicJpaDao;
import com.pearlox.framework.domain.BasicObject;

/**
 * User: Andrew Date: 3/27/13
 *
 * The purpose of this class is to fix issue with new transaction creation (instead of transaction re-use) on read-only
 * operations like findAll() and findById(). This issue is introduced in com.pearlox.framework.
 *
 * @param <T> the generic type
 */
public class BasicJpaDaoExt<T extends BasicObject> extends BasicJpaDao<T> {
        /**
     * Instantiates a new basic jpa dao ext.
     *
     * @param aType the a type
     */
    public BasicJpaDaoExt(final Class<T> aType) {
        super(aType);
    }

    /* (non-Javadoc)
     * @see com.pearlox.framework.dao.impl.BasicJpaDao#findAll()
     */
    @SuppressWarnings("unchecked")
    @Override
    public Collection<T> findAll() throws Exception {
        String selectQuery = "Select obj from " + type.getSimpleName() + " obj ORDER BY obj.id";
        Query query = getEntityManager().createQuery(selectQuery);
        return query.getResultList();
    }

    /* (non-Javadoc)
     * @see com.pearlox.framework.dao.impl.BasicJpaDao#findById(java.lang.Long)
     */
    @Override
    public T findById(final Long id) throws Exception {
        return getEntityManager().find(type, id);
    }
}
