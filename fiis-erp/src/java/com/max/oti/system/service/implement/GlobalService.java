/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.service.implement;

import com.max.oti.system.dao.interfac.IGlobalDao;
import com.max.oti.system.service.interfac.IGlobalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author max
 */
public class GlobalService implements IGlobalService {

 
    @Autowired
    @Qualifier("globalDao")
    IGlobalDao globalDao;
    
    @Override
    public List listHQL(String hql, Class clazz) throws Exception {
        return globalDao.listHQL(hql, clazz);
    }

    @Override
    public List listHQL(String hql) throws Exception {
        return globalDao.listHQL(hql);
    }

    @Override
    public int updateHQL(String hql) throws Exception {
        return globalDao.updateHQL(hql);
    }
    
}
