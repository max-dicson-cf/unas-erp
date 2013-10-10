/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.bean;

import com.max.oti.system.service.interfac.IGlobalService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;
import org.omnifaces.util.Faces;

/**
 *
 * @author max
 */
@ManagedBean
@SessionScoped
public class IndexLoginBean implements Serializable {
        
    private String navigation = "./pages/sppp/home.xhtml";
   
    
    public void logOut() throws ServletException, IOException {
        Faces.logout();
        Faces.invalidateSession();
        Faces.redirect("login.jsf");
    }

    public String getNavigation() {
        return navigation;
    }

    public void setNavigation(String navigation) {
        this.navigation = navigation;
    }

}
