<%-- 
    Document   : shop
    Created on : 2013-maj-13, 12:57:46
    Author     : Sara Frisk
    Author     : Emma Rangert
--%>

<%@page import="beans.IngredientListBean"%>
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
        <div id="shop">
            
            
                <h1>Pizzeria Online</h1>
            
            
                <div id="edit_profile">
                    <a  href="PizzaShopServlet?action=editProfile">Redigera profil</a>
                </div>
            
            

            <div id="ingredient_container">
            	
                <jsp:useBean id="ingredientBean" class="beans.IngredientListBean"/> 
                
                <c:forEach var="ingredient" items="${ingredientBean.ingredientList}">

                    
                    <div class="ingredient">
                        <div class="name"><c:out value="${ingredient.getName()}"/></div>
                        <div class="price"><c:out value="${ingredient.getPrice()}"/> :-</div>
                        <div class="pick">
                            <input type="checkbox" name="pick_input"/>
                        </div>
                    </div>
                    

                 </c:forEach>

            </div>
            
            <div id="shop_feedback_panel">
                <label id="pizza_price_label">Pris:</label>
                <input id="pizza_price_textbox" type="text"/>
                <input id="add_pizza_button" type="button" value="Lägg till pizza i kundvagnen"/>
            </div>
            
            <div id="cart">
                <h3 id="cart_header">Kundvagn</h3>
                <a href="PizzaShopServlet?action=checkout">Till kassan</a>
            </div>
  
        </div>
    </body>
</html>
