package com.max.oti.system.filter;

import com.max.oti.system.util.FacesUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.jsf"})
public class AuthFilter implements Filter {
        
    public AuthFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {

            
            // check whether session variable is set
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession ses = req.getSession(false);
            // allow user to proccede if url is login.xhtml or user logged in or
            // user is accessing any page in 
            // public folder
            String reqURI = req.getRequestURI();
            if (reqURI.indexOf("/login.jsf") >= 0
                    || (ses != null && ses.getAttribute(FacesUtil.ATTRIBUTE_ID) != null)
                    || reqURI.indexOf("/public/") >= 0
                    || reqURI.contains("javax.faces.resource")) {
                
                chain.doFilter(request, response);
                
            } else {
                res.sendRedirect(req.getContextPath() + "/login.jsf");
            } // Anonymous
            // user.
            // Redirect
            // to
            // login
            // page
        } catch (Throwable t) {
            
            System.err.println("Mensaje de Error en Filtro: " + t.getMessage());
        } 
    } // doFilter

    @Override
    public void destroy() {        
    }
}