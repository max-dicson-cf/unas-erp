/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.dao.hibernate;

import com.max.oti.system.dao.interfac.IUserDao;
import com.max.oti.system.dao.util.GenericEntityDao;
import com.max.oti.system.model.User;

/**
 *
 * @author Alberto
 */
public class UserDao extends GenericEntityDao<User, Long> implements IUserDao{
    
}
