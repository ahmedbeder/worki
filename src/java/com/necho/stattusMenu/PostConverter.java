package com.necho.stattusMenu;
 
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
 
import javax.faces.application.FacesMessage;
import javax.faces.convert.ConverterException;
 
@FacesConverter("themeConverter")
public class PostConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                PostService service = (PostService) fc.getExternalContext().getApplicationMap().get("themeService");
                return service.getPostwithlist().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((PostWith) object).getId());
        }
        else {
            return null;
        }
    }   
}         
           