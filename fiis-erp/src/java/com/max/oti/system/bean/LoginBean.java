/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.bean;

import com.max.oti.system.model.User;
import com.max.oti.system.service.interfac.IGlobalService;
import com.max.oti.system.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Faces;

/**
 *
 * @author max
 */
@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {
//holaa
    
    //hola mundooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    private Integer idSelectedRadio = 1;
    @ManagedProperty("#{globalService}")
    IGlobalService globalService;
    private User user = new User();

    public void logginProcess() {

        try {
            if (idSelectedRadio == null) {
                FacesUtil.addMessage("Debe seleccionar una opción de ingreso", null, FacesMessage.SEVERITY_WARN);
            } else {
                if (idSelectedRadio == 1) {

                    List<User> listUser = globalService.listHQL("FROM User u WHERE u.nick='" + user.getNick() + "' "
                            + "AND u.password='" + user.getPassword() + "' AND "
                            + "u.idTypeUser=1");
                    for (int i = 0; i < listUser.size(); i++) {
                        System.out.println(listUser.get(i));

                    }

                    if (listUser.size() > 0) {
                        String dniLogin = listUser.get(0).getDniPerson();
                        Faces.getSession().setAttribute(FacesUtil.ATTRIBUTE_ID, listUser.get(0).getId());
                        Faces.getSession().setAttribute(FacesUtil.ATTRIBUTE_USER_NAME, listUser.get(0).getNick());
                        Faces.redirect("index.jsf");
                    }
                } else {
                }


            }

        } catch (Exception ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //<editor-fold defaultstate="collapsed" desc=" METODOS GETTER Y SETTER ">
    public IGlobalService getGlobalService() {
        return globalService;
    }

    public void setGlobalService(IGlobalService globalService) {
        this.globalService = globalService;
    }

    public Integer getIdSelectedRadio() {
        return idSelectedRadio;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setIdSelectedRadio(Integer idSelectedRadio) {
        this.idSelectedRadio = idSelectedRadio;
    }
    //</editor-fold>
}
