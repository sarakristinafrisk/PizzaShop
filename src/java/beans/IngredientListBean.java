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
    
    private Collection ingredientList;
    private String url = null;
    
    // constructor used for testing
    public IngredientListBean() throws Exception {
        this(
          "jdbc:mysql://localhost/pizzashop?user=root&password=yourpasswordhere");
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
                iBean.setPrice(resultSet.getInt("INGREDIENT_PRICE")); // problem med double
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
    
    public Collection getIngredientList() {
        return ingredientList;
    }
    
    
}
