/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.max.oti.system.util.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.SelectItemsConverter;

/**
 *
 * @author max
 */
@FacesConverter("SelectQualifiedObject")
public class QualifiedObjectConverter extends SelectItemsConverter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        //Integer id = (value instanceof QualifiedObject) ? ((QualifiedObject) value).getId() : null;
        //return (id != null) ? String.valueOf(id) : null;
        return "";
    }
    
    
    
}
