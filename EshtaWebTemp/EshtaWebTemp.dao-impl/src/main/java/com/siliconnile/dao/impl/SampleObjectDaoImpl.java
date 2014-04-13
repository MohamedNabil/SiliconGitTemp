package com.siliconnile.dao.impl;

import com.pearlox.framework.dao.impl.BasicJpaDao;
import com.siliconnile.dao.SampleObjectDao;
import com.siliconnile.domain.SampleObject;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * User: Andrew
 * Date: 6/18/13
 */
@Repository
public class SampleObjectDaoImpl extends BasicJpaDao<SampleObject> implements SampleObjectDao {
    public SampleObjectDaoImpl() {
        super(SampleObject.class);
    }

    @Override
    public SampleObject findById2(Long id) {
        Query query = getEntityManager().createQuery("select so from SampleObject so where so.id = :id");
        query.setParameter("id", id);
        return (SampleObject) query.getSingleResult();
    }
}
