package beans;

import java.sql.*;
import java.util.*;
import java.io.*;

// save an order in the database

public class OrderBean  {

    private Connection con;
    private PreparedStatement orderPstmt;
    private PreparedStatement orderItemPstmt;
    private PreparedStatement orderIngredientPstmt;
    private PreparedStatement orderIngredientStockPstmt;

    private PreparedStatement stmt = null;
    private ResultSet rs=null;

    private int orderId;
    private String url;
    private CartBean cartBean;
    private String username;


    private static String orderSQL;
    private static String orderItemSQL;
    private static String orderIngredientSQL;
    private static String orderIngredientStockSQL;

  public OrderBean(String _url, CartBean _cartBean, String _username){
    url = _url;
    cartBean = _cartBean;
    username = _username;
  }

  /**
   * Saves an order in the database
   */
  public void saveOrder() throws Exception{
    orderSQL="INSERT INTO ORDERS(order_customer_username,";
    orderSQL += " order_price)";
    orderSQL += " VALUES(?,?)";
    try{

	// load the driver and get a connection

	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(url);

	// turn off autocommit to handle transactions yourself

	con.setAutoCommit(false);
	orderPstmt = con.prepareStatement(orderSQL);
	orderPstmt.setString(1, username);
	orderPstmt.setInt(2, cartBean.getTotalPrice());

	orderPstmt.execute();

        
        
        // get the value of the last stored AUTO_INCREMENT variable
        // i. e. ORDER_ID       
        stmt = con.prepareStatement("SELECT LAST_INSERT_ID()");
        rs = stmt.executeQuery();
        rs.next();
        orderId=rs.getInt(1);
      
	// now handle all items in the cart
	saveOrderItems();
	cartBean.clear();
        
	con.commit();  // end the transaction
    }
    catch(Exception e){
	try{
	    con.rollback();    // failed, rollback the database
	}
	catch(Exception ee){}
	throw new Exception("Error saving Order", e);
    }
    finally{
	try {
	    rs.close();
	}
	catch(Exception e) {}       
	try {
	    stmt.close();
	}
	catch(Exception e) {}
	try{
	    orderPstmt.close();
	}
	catch(Exception e){}
	try{
	    orderItemPstmt.close();
	}
	catch(Exception e){}
        try{
	    orderIngredientPstmt.close();
	}
	catch(Exception e){}
	try{
	    orderIngredientStockPstmt.close();
	}
	catch(Exception e){}
	try{
	    con.close();
	}
	catch(Exception e){}
    }
  }

/**
 * Saves the different items in the order
 */
  private void saveOrderItems() throws Exception{

      
         orderItemSQL="INSERT INTO pizzas(order_order_id)";
         orderItemSQL += "VALUES (?)";
         
         orderItemPstmt = con.prepareStatement(orderItemSQL);
      
         orderIngredientSQL="INSERT INTO pizzas_has_ingredients(pizzas_id,";
         orderIngredientSQL += " ingredients_ingredient_name)";
         orderIngredientSQL += "VALUES (?,?)";
          
         orderIngredientPstmt = con.prepareStatement(orderIngredientSQL);

         
         
         
      //Loop through all pizzas
      for (int i=0; i<cartBean.getCart().size(); i++) {
          
          

         orderItemPstmt.setInt(1,orderId);
         orderItemPstmt.execute();
         
         int pizzaId;
         
         stmt = con.prepareStatement("SELECT LAST_INSERT_ID()");
         rs = stmt.executeQuery();
         rs.next();
         pizzaId=rs.getInt(1);
         
         Object[] pizza = (Object[]) cartBean.getCart().get(i);
        
         ArrayList<IngredientBean> ingredients = (ArrayList<IngredientBean>) pizza[1];
         
         //Loop through all ingredients on a single pizza
         for (int j=0; j<ingredients.size(); j++) {
            orderIngredientPstmt.setInt(1,pizzaId);
            orderIngredientPstmt.setString(2,ingredients.get(j).getName());
            
            orderIngredientPstmt.executeUpdate();
           
            int stock = ingredients.get(j).getStock() - 1;
            orderIngredientStockSQL="UPDATE ingredients SET ingredient_stock=" + stock + 
                    " WHERE ingredient_name='" + ingredients.get(j).getName() + "';";

            ingredients.get(j).setStock(stock);
            
            orderIngredientStockPstmt = con.prepareStatement(orderIngredientStockSQL);
            orderIngredientStockPstmt.execute();
          
         }
         
      }
  }
      
}



