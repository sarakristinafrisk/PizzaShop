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
        <div id="shop">
            
            
            <h1>Pizzeria Online</h1>
            
            
            <div id="edit_profile">
            
                <jsp:useBean id="currentUser" class="beans.ProfileBean" scope="application"/>                
 
                            
                            
                Inloggad: <c:out value="${currentUser.username}"/>
                
                <form id action=PizzaShopServlet?action=editProfile method="post">
                    <input type="submit" value="Edit profile">
                </form>
                <form id action=PizzaShopServlet?action=logOut method="post">
                    <input type="submit" value="Logout">
                </form>
            </div>
            
            
            <form method="POST" action=PizzaShopServlet?action=addToCart>

                <div id="ingredient_container">
                    
                    <div class="column_labels">
                    <label id="name_label">Name</label>
                    <label id="price_label">Price</label>
                    <label id="stock_label">Quantity</label>
                    </div>
                    
                    <jsp:useBean id="ingredientBean" class="beans.IngredientListBean"/> 

                    <c:forEach var="ingredient" items="${ingredientBean.ingredientList}">

                        <c:if test = "${ingredient.getStock() != 0}">
                            <div class="ingredient" id="in_stock">
                                <div class="name"><c:out value="${ingredient.getName()}"/></div>
                                <div class="price"><c:out value="${ingredient.getPrice()}"/> :-</div>
                                <div class="pick">
                                    <input type="checkbox" name="pick_input" value="${ingredient.getName()}" />
                                </div>
                            </div>
                        </c:if>
                           
                        <c:if test = "${ingredient.getStock() == 0}">
                            <div class="ingredient">
                                <div class="name"><font color="#ccc"><c:out value="${ingredient.getName()}"/></font></div>
                                <div class="price"><font color="#ccc">Out of stock</font></div>
                                    <div class="pick">
                                        <input type="checkbox" name="pick_input" disabled="disabled" value="${ingredient.getName()}" />
                                    </div>
                            </div>
                        </c:if>                                 




                    </c:forEach>

                </div>

                <div id="shop_feedback_panel">
                    <input id="add_pizza_button" type="submit" value="Add pizza to cart"/>
                </div>
                    
            </form>
            
            <div id="cart">
                <h3 id="cart_header">Cart</h3>
                <jsp:useBean id="cartBean" class="beans.CartBean" scope="application"/>

                    <c:forEach var="pizza" items="${cartBean.cart}">

                        <div class="pizza">
                           <div class="name">Pizza with: 
                               
                               <c:forEach var="pizzaIngredient" items="${pizza[1]}">
                                    <c:out value="${pizzaIngredient.getName()} "/>
                               </c:forEach>

                           </div>
                            <form class="remove" method="post" action=PizzaShopServlet?action=removeFromCart&pizzaId=${pizza[0]}>
                                <input type="submit" value="Remove"/>
                            </form>
                        </div>

                    </c:forEach>
                
             <form action=PizzaShopServlet?action=checkout method="post">
                <label id="cart_price_label">Total price: </label>
                <input id="cart_price" type="text" name="cart_price" value="${cartBean.getTotalPrice()}"/>
                <input type="submit" value="Check out">
            </form>
            </div>
  
        </div>
    </body>
</html>
