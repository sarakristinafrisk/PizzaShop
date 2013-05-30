/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.*;
import java.util.*;


/**
 *
 * @author Emma Rangert
 * @author Sara Frisk
 */
public class ProfileListBean {
    
    private ArrayList profileList;
    private String url = null;
    
    private ProfileBean currentUser = new ProfileBean();

    
    // constructor used for testing
    public ProfileListBean() throws Exception {
        this(
          "jdbc:mysql://localhost/PizzaShop?user=root&password=yourpasswordhere");
    }
    
    public ProfileListBean(String _url) throws Exception {
        
        url = _url;

        Connection databaseConnection = null;
        Statement sqlStatement = null;
        ResultSet resultSet = null;
        profileList = new ArrayList();
        
        try {
            // create database connection and load jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            databaseConnection = DriverManager.getConnection(url);

            // load ingredients from the data base
            sqlStatement = databaseConnection.createStatement();
            String sql = "SELECT * FROM CUSTOMER";

            // save them in the result set
            resultSet = sqlStatement.executeQuery(sql);

            // create a bean for every ingredient in the result set
            while (resultSet.next()) {
                ProfileBean pBean = new ProfileBean();

                pBean.setUsername(resultSet.getString("customer_username"));
                pBean.setPassword(resultSet.getString("customer_password"));
                pBean.setFirstname(resultSet.getString("customer_name"));
                pBean.setSurname(resultSet.getString("customer_surname"));
                pBean.setEmail(resultSet.getString("customer_email"));
                pBean.setAddress(resultSet.getString("customer_address"));
                pBean.setPostcode(resultSet.getInt("customer_zipcode"));
                pBean.setCity(resultSet.getString("customer_city"));
                pBean.setCountry(resultSet.getString("customer_country"));
                pBean.setIsAdmin(resultSet.getBoolean("customer_isadmin"));

                profileList.add(pBean);
            }
        } 
        catch(SQLException sqle) {
            throw new Exception(sqle);
        }
        
        // close all connections
        finally {
            try {
                resultSet.close();
            } catch(Exception e) {}
            try {
                sqlStatement.close();
            } catch(Exception e) {}
            try {
                databaseConnection.close();
            } catch(Exception e) {}
        }
    }
    
    public ArrayList getProfileList() {
        return profileList;
    }
  
    public ProfileBean getCurrentUser() {
        return currentUser;
    }
    
    public void setCurrentUser(String user) {
        ArrayList<ProfileBean> list = profileList;
        for (int i=0; i<list.size(); i++) {
            if (user.equals(list.get(i).getUsername())) {
                currentUser.setUsername(list.get(i).getUsername());
                currentUser.setPassword(list.get(i).getPassword());
                currentUser.setFirstname(list.get(i).getFirstname());
                currentUser.setSurname(list.get(i).getSurname());
                currentUser.setEmail(list.get(i).getEmail());
                currentUser.setAddress(list.get(i).getAddress());
                currentUser.setPostcode(list.get(i).getPostcode());
                currentUser.setCity(list.get(i).getCity());
                currentUser.setCountry(list.get(i).getCountry());
                currentUser.setIsAdmin(list.get(i).getIsAdmin());          
            }
        }
    }
    
    public Boolean checkIfExisting(String username) {
        Boolean exist = false;
        ArrayList<ProfileBean> list = profileList;
        for (int i=0; i<list.size(); i++) {
            if (username.equals(list.get(i).getUsername())) {
                exist = true;
            }
        }
        return exist;   
    }
    
    
    public Boolean checkIfExisting(String username, String password) {
        Boolean exist = false;
        ArrayList<ProfileBean> list = profileList;
        for (int i=0; i<list.size(); i++) {
            if (username.equals(list.get(i).getUsername())) {
                if (password.equals(list.get(i).getPassword())) {
                    exist = true;
                }     
            }
        }
        return exist;   
    }
    
    public Boolean checkIfExistingAdmin(String username, String password) {
        Boolean exist = false;
        ArrayList<ProfileBean> list = profileList;
        for (int i=0; i<list.size(); i++) {
            if (username.equals(list.get(i).getUsername()) && list.get(i).getIsAdmin()) {
                if (password.equals(list.get(i).getPassword())) {
                    exist = true;
                }     
            } else {
            }
        }
        return exist;  
    }
    
    
    public void addProfileBean(ProfileBean pBean) throws Exception {
        profileList.add(pBean);
        
        
        Connection databaseConnection = null;
        Statement sqlStatement = null;
        ResultSet resultSet = null;
        
        try {
            // create database connection and load jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            databaseConnection = DriverManager.getConnection(url);

            PreparedStatement st = databaseConnection.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?,?)");
            
            st.setString(1,pBean.getUsername());
            st.setString(2,pBean.getPassword());
            st.setString(3,pBean.getFirstname());
            st.setString(4,pBean.getSurname());
            st.setString(5,pBean.getEmail());
            st.setString(6,pBean.getAddress());
            st.setInt(7, pBean.getPostcode());
            st.setString(8,pBean.getCity());
            st.setString(9,pBean.getCountry());
            st.setBoolean(10, false);

            st.executeUpdate();
            
        }  catch(SQLException sqle) {
            throw new Exception(sqle);
        }
        
        // close all connections
        finally {

            try {
                databaseConnection.close();
            } catch(Exception e) {}
        }

    }
    
    
    public void updateProfileBean(ProfileBean pBean) throws Exception {                
        Connection databaseConnection = null;
        Statement sqlStatement = null;
        ResultSet resultSet = null;
        
        try {
            // create database connection and load jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            databaseConnection = DriverManager.getConnection(url);

            PreparedStatement st = databaseConnection.prepareStatement("update customer SET "
                    + "customer_username='" + pBean.getUsername() + "', "
                    + "customer_password='" + pBean.getPassword() + "', "
                    + "customer_name='" + pBean.getFirstname() + "', "
                    + "customer_surname='" + pBean.getSurname() + "', "
                    + "customer_email='" + pBean.getEmail() + "', "
                    + "customer_address='" + pBean.getAddress() + "', "
                    + "customer_zipcode=" + pBean.getPostcode() + ", "
                    + "customer_city='" + pBean.getCity() + "', "
                    + "customer_country='" + pBean.getCountry() 
                    + "' WHERE customer_username = '" + pBean.getUsername() + "';");
               
            st.executeUpdate();
            
        }  catch(SQLException sqle) {
            throw new Exception(sqle);
        }
        
        // close all connections
        finally {

            try {
                databaseConnection.close();
            } catch(Exception e) {}
        }
        
        for (int i=0; i<profileList.size(); i++) {
            ProfileBean temp = (ProfileBean) profileList.get(i);
            if (pBean.getUsername().equals(temp.getUsername())) {
                temp.setPassword(pBean.getPassword());
                temp.setFirstname(pBean.getFirstname());
                temp.setSurname(pBean.getSurname());
                temp.setEmail(pBean.getEmail());
                temp.setAddress(pBean.getAddress());
                temp.setPostcode(pBean.getPostcode());
                temp.setCity(pBean.getCity());
                temp.setCountry(pBean.getCountry());
                temp.setIsAdmin(pBean.getIsAdmin()); 
            }
            
        }
        
  
        

    }
}
