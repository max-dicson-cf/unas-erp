package com.max.oti.system.util;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import org.omnifaces.util.Faces;

import org.primefaces.context.RequestContext;

public class FacesUtil {
    
    /**
     * Attributo alternativo para mostrar nombre del usuario logeado
     */
    public static String ATTRIBUTE_USER_NAME = "username";
    /**
     * Attributo para guardar el sesion este representa el id del usuario logeado
     * por lo que es necesario guardarlo.
     */
    public static String ATTRIBUTE_ID = "id";
    
    /**
     * Para ejecutar Java Script como tambien poder hacer update a algun elemento
     * de la vista
     * @return 
     */
    public static RequestContext getRequestContext() {
        return RequestContext.getCurrentInstance();
    }

    /**
     * Principalmente para redireccionar hacia una pagina con
     * sentRedirect()
     * @deprecated 
     * @return 
     */
    public static HttpServletResponse getResponse() {
        return ((HttpServletResponse) Faces.getExternalContext().getResponse());
    }  
    
    /**
     * Con esto nos deslogeamos, el siguiente paso que deberia realizar el 
     * de Redireccionar.
     * @throws ServletException 
     */
    public static void logOut() throws ServletException{
        Faces.logout();
    }
    
    /**
     * Para Enviar mensajes a la vista
     * @param summary El contenido que tendra los mensajes
     * @param details Los detalles que se mostraran despues de summary
     * @param TYPE_MESSAGE El tipo de mensaje que mostrara, Alert, warning, error, fatal
     */
    public static void addMessage(String summary, String details, FacesMessage.Severity TYPE_MESSAGE) {
        FacesMessage message = new FacesMessage(TYPE_MESSAGE, summary, details);
        Faces.getContext().addMessage(null, message);
    }
    
    public static int encryptUser (String userName, String password) {
        return (userName + password).hashCode() / 2;
    }
    
}
