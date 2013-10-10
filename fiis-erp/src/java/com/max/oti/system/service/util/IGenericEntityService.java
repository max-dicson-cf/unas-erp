/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.service.util;

/**
 *
 * @author max
 */
public interface IGenericEntityService<T> {
    
    /**
     * Guarda un nuevo registro en la base de datos.
     * Sus relaciones deben estar completas, puesto que puede ocurrir un error 
     * al subir a la base de datos.
     * 
     * @param object nuevo objeto llena con sus relaciones
     * @return retorna el ID del objeto subido.
     */
    public int save(T object) throws Exception;

    /**
     * Realiza un <code>update</code> en la base de datos
     * se debe tener en cuenta que el objeto ya debe existir en la
     * base de datos.
     * 
     * @param object el Id debe existir en la base de datos.
     */
    public void update(T object) throws Exception;

    /**
     * Realiza un <code>insert</code>, <code>update</code>,
     * <code>delete</code>, en la base de datos, segun sea el caso
     * de sus relaciones.
     * 
     * @param object Objeto relacionado.
     */
    public void saveOrUpdate(T object) throws Exception;

    /**
     * Borra en cascada todas las realciones del objeto en la base de datos
     * 
     * @param object Tiene que tener lleno sus datos para poder borrar todo en cascada.
     */
    public void delete(T object) throws Exception;

    /**
     * Metodo que devuelve un objeto completo ingresando como parametro su Id
     * 
     * @param id Su identificador de la clase que esta relacionado con la base de 
     * datos
     * 
     * @return Retorna un Objeto del tipo de la misma clase.
     */
    public T getById(java.io.Serializable id) throws Exception;
    
}
