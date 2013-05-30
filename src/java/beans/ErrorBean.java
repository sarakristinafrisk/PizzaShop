/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author sarafrisk
 */
public class ErrorBean implements Serializable {
    
    private Boolean loginError;
            
    public ErrorBean() {
    }
    
    public Boolean getLoginError() {
        return loginError;
    }
    
    public void setLoginError(Boolean error) {
        loginError = error;
    }
    
    

}
