/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.dao.util;

import java.util.List;

/**
 *
 * @author max
 */
public interface IGenericGlobalDao {
    
    /**
     * Obtiene una lista de objetos y pregunta si 
     * los resultados los quieres transformar.
     * @param hql "select Class.id, Class.name from Class
     * @param clazz Transforma a la clase los objetos recibidos
     * @return 
     */
    public List listHQL(String hql, Class clazz) throws Exception;
    
    /**
     * Optiene una lista de objetos con.
     * @param hql "from Class"
     * @return
     * @throws Exception 
     */
    public List listHQL(String hql) throws Exception;
    
    /**
     * Realiza Update a los campos que no sean entidades
     * @param hql "update Class c set c.name='sdf' where c.id=1"
     * @return Numero de filas afectadas
     * @throws Exception 
     */
    public int updateHQL(String hql) throws Exception;
    
}
