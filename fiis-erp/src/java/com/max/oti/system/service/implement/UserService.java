/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.service.implement;

import com.max.oti.system.dao.interfac.IUserDao;
import com.max.oti.system.model.User;
import com.max.oti.system.service.interfac.IUserService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Alberto
 */
public class UserService implements IUserService{

    @Autowired
    @Qualifier("userDao")
    IUserDao userDao;
    
    @Override
    public int save(User object) throws Exception {
        return userDao.save(object);
    }

    @Override
    public void update(User object) throws Exception {
        userDao.update(object);
    }

    @Override
    public void saveOrUpdate(User object) throws Exception {
        userDao.saveOrUpdate(object);
    }

    @Override
    public void delete(User object) throws Exception {
        userDao.delete(object);
    }

    @Override
    public User getById(Serializable id) throws Exception {
        return userDao.getById(id);
    }
    
}
