package com.max.oti.system.dao.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public class GenericEntityDao<T, ID extends Serializable> implements
        IGenericEntityDao<T, ID> {

    protected SessionFactory sessionFactory;
    private final Class<T> oClass;

    public GenericEntityDao() {
        this.oClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    @Override
    public Class<T> getObjectClass() {
        return this.oClass;
    }

    @Transactional(readOnly = false, rollbackFor=Exception.class)
    @Override
    public int save(T objeto) throws Exception {
        return (Integer) getSessionFactory().getCurrentSession().save(objeto);
    }

    @Transactional(readOnly = false, rollbackFor=Exception.class)
    @Override
    public void update(T objeto) throws Exception {
        getSessionFactory().getCurrentSession().update(objeto);
    }
    
    @Transactional(readOnly = false, rollbackFor=Exception.class)
    @Override
    public void saveOrUpdate(T object) throws Exception {
        getSessionFactory().getCurrentSession().saveOrUpdate(object);
    }

    @Transactional(readOnly = false, rollbackFor=Exception.class)
    @Override
    public void delete(T objeto) throws Exception {
        getSessionFactory().getCurrentSession().delete(objeto);
    }

    @Override
    public T getById(Serializable id) throws Exception {
        return (T) getSessionFactory()
                   .getCurrentSession().get(oClass, id);
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }    
    
}
