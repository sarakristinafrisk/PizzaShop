<%-- 
    Document   : shop
    Created on : 2013-maj-13, 12:57:46
    Author     : Sara Frisk
    Author     : Emma Rangert
--%>

<%@page import="beans.IngredientListBean"%>
<%@page import="beans.CartBean"%>
<%@page import="beans.ProfileBean"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
          
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css.css" />

        <title>Shop</title>
    </head>
    <body>
        <div id="admin">
            
            
        <h1>Pizzeria Online</h1>
             
            <div id="ingredient_container">

                <div class="column_labels">
                    <label id="name_label">Namn</label>
                    <label id="price_label">Pris</label>
                    <label id="stock_label">Antal</label>
                </div>
            
                <jsp:useBean id="ingredientBean" class="beans.IngredientListBean" scope="application"/> 

                <c:forEach var="ingredient" items="${ingredientBean.ingredientList}">

                    <div class="ingredient">
                         <form method="post" action=PizzaShopServlet?action=updateIngredient>

                            <input class="name" type="text" name="name_admin" value="${ingredient.name}">
                            <input class="price" type="text" name="price_admin" value="${ingredient.price}">
                            <input class="stock" type="text" name="stock_admin" value="${ingredient.stock}">

                            <input type="submit" class="update" value="Update"/>
                         </form>
                    </div>
                            
                </c:forEach>
                        
            </div> 
                
            <div id="new_ingredient_container">
                <h3>Add ingredient</h3>
                <div class="column_labels">
                    <label id="name_label">Namn</label>
                    <label id="price_label">Pris</label>
                    <label id="stock_label">Antal</label>
                </div>
                <form  method="post" action=PizzaShopServlet?action=addIngredient>
                     <input class="name" type="text" name="new_name">
                     <input class="price" type="text" name="new_price">
                     <input class="stock" type="text" name="new_stock">
                     <input class="add" type="submit" value="Add"/>
                </form>
           </div>
       </div>      
    </body>
</html>
