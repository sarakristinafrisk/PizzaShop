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
                pBean.setPostcode(resultSet.getString("customer_zipcode"));
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
            st.setInt(7,Integer.parseInt(pBean.getPostcode()));
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
    /*  
       try {
           String sql = "insert into customer(customer_username, customer_password, customer_name, customer_surname, "
                    + "customer_email, customer_address, customer_zipcode, customer_city, customer_country, customer_isadmin) "
                    + "VALUES('" + pBean.getUsername() + "','" + pBean.getPassword() + "','" + pBean.getFirstname() + "','" + pBean.getSurname() + "','" 
                    + pBean.getEmail() + "','" + pBean.getAddress() + "'," + Integer.parseInt(pBean.getPostcode()) + ",'" + pBean.getCity() + "','" 
                    + pBean.getCountry() + "'," + false + ")";


           
          String sql = "insert into customer(customer_username, customer_isadmin) VALUES('" + pBean.getUsername() + "'," + false + ")";
            // save them in the result set
            sqlStatement.executeQuery(sql);
            
            
        } catch(SQLException sqle) {
            throw new Exception(sqle);
        }*/
    }
}
