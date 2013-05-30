package beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.*;

/**
 *
 * @author sarafrisk
 */
public class ProfileBean {
    private String username;
    private String password;
    private String firstname;
    private String surname;
    private String email;
    private String address;
    private int postcode;
    private String city;
    private String country;
    private Boolean isAdmin;
    
    /** Creates a new instance of IngredientBean */
    public ProfileBean() {
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String _username) {
        username = _username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String _password) {
        password = _password;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public void setFirstname(String _firstname) {
        firstname = _firstname;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String _surname) {
        surname = _surname;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String _address) {
        address = _address;
    }
    
    public int getPostcode() {
        return postcode;
    }
    
    public void setPostcode(int _postcode) {
        postcode = _postcode;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String _email) {
        email = _email;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String _city) {
        city = _city;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String _country) {
        country = _country;
    }
    
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    
    public void setIsAdmin(Boolean _isAdmin) {
        isAdmin = _isAdmin;
    }
    
}
