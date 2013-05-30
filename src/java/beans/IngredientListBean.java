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
public class IngredientListBean {
    
    private ArrayList ingredientList;
    private String url = null;
    
    // constructor used for testing
    public IngredientListBean() throws Exception {
        this(
          "jdbc:mysql://localhost/PizzaShop?user=root&password=yourpasswordhere");
    }
    
    public IngredientListBean(String _url) throws Exception {
        
        url = _url;
        
        Connection databaseConnection = null;
        Statement sqlStatement = null;
        ResultSet resultSet = null;

        ingredientList = new ArrayList();
        
        try {
            // create database connection and load jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            databaseConnection = DriverManager.getConnection(url);

            // load ingredients from the data base
            sqlStatement = databaseConnection.createStatement();
            String sql = "SELECT INGREDIENT_NAME, INGREDIENT_PRICE, INGREDIENT_STOCK FROM INGREDIENTS";

            // save them in the result set
            resultSet = sqlStatement.executeQuery(sql);

            // create a bean for every ingredient in the result set
            while (resultSet.next()) {
                IngredientBean iBean = new IngredientBean();

                iBean.setName(resultSet.getString("INGREDIENT_NAME"));
                iBean.setPrice(resultSet.getInt("INGREDIENT_PRICE")); 
                iBean.setStock(resultSet.getInt("INGREDIENT_STOCK"));
                ingredientList.add(iBean);
            }
        } 
        catch(SQLException sqle) {
            System.out.print("hej");
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
    
    public ArrayList getIngredientList() {
        return ingredientList;
    }
   
    
    
    public void updateIngredient(IngredientBean newBean) {
        
        for (int i=0; i<ingredientList.size(); i++) {
            IngredientBean oldBean = (IngredientBean) ingredientList.get(i);
            if (oldBean.getName().equals(newBean.getName())) {
                oldBean.setName(newBean.getName());
                oldBean.setPrice(newBean.getPrice());
                oldBean.setStock(newBean.getStock());
            }   
        }
    } 

    
    
    public void addIngredientBean(IngredientBean iBean) throws Exception {        
        
        Connection databaseConnection = null;
        Statement sqlStatement = null;
        ResultSet resultSet = null;
        
        try {
            // create database connection and load jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            databaseConnection = DriverManager.getConnection(url);

            PreparedStatement st = databaseConnection.prepareStatement("insert into ingredients values(?,?,?)");
            
            st.setString(1,iBean.getName());
            st.setInt(2,iBean.getPrice());
            st.setInt(3,iBean.getStock());
            
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
        
        ingredientList.add(iBean);

    }
    
    
    public void updateIngredientBean(IngredientBean iBean, int index) throws Exception {        
        Connection databaseConnection = null;
        Statement sqlStatement = null;
        ResultSet resultSet = null;
        
        try {
            // create database connection and load jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            databaseConnection = DriverManager.getConnection(url);

            PreparedStatement st = databaseConnection.prepareStatement("update ingredients SET "
                    + "ingredient_name='" + iBean.getName() + "', "
                    + "ingredient_price=" + iBean.getPrice() + ", "
                    + "ingredient_stock=" + iBean.getStock() 
                    + " WHERE ingredient_name = '" + iBean.getName() + "';");
               
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
        
        
        IngredientBean oldBean = (IngredientBean) ingredientList.get(index);
        oldBean.setName(iBean.getName());
        oldBean.setPrice(iBean.getPrice());
        oldBean.setStock(iBean.getStock());

    }
    
    public void deleteIngredientBean(String name, int index) throws Exception {        
        Connection databaseConnection = null;
        Statement sqlStatement = null;
        ResultSet resultSet = null;
        
        try {
            // create database connection and load jdbc driver
            Class.forName("com.mysql.jdbc.Driver");
            databaseConnection = DriverManager.getConnection(url);

            PreparedStatement st = databaseConnection.prepareStatement(
                   "DELETE FROM ingredients WHERE ingredient_name='" + name + "';");

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
        
        ingredientList.remove(index);

    }

   
    
    
}
