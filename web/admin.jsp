<%-- 
    Document   : admin
    Created on : 2013-maj-13, 12:57:46
    Author     : Sara Frisk
    Author     : Emma Rangert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                
                <div class="ingredient">
                    <input class="name" type="text" name="name">
                    <input class="price" type="text" name="price">
                    <input class="stock" type="text" name="stock">
                </div>
             
                <div class="ingredient">
                    <input class="name" type="text" name="name">
                    <input class="price" type="text" name="price">
                    <input class="stock" type="text" name="stock">
                </div>
            </div>
            <input id="add_ingredient" type="button" value="Lägg till ingrediens"/>
            
        </div>
    </body>
</html>
