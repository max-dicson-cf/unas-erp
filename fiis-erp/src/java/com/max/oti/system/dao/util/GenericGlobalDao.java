/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.dao.util;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author max
 */
@Transactional(readOnly = true)
public class GenericGlobalDao implements IGenericGlobalDao {

    protected SessionFactory sessionFactory;
    
    @Override
    public List listHQL(String hql, Class clazz) throws Exception{ 
        return getSessionFactory().getCurrentSession()
                .createQuery(hql)
                .setResultTransformer(Transformers.aliasToBean(clazz))
                .list();
    }

    @Override
    public List listHQL(String hql) throws Exception {
        return getSessionFactory().getCurrentSession()
                .createQuery(hql)
                .list();
    }

    @Transactional(readOnly = false, rollbackFor=Exception.class)
    @Override
    public int updateHQL(String hql) throws Exception {
        return getSessionFactory().getCurrentSession()
                .createQuery(hql)
                .executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    
}
