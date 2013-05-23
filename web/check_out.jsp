<%-- 
    Document   : index
    Created on : 2013-maj-13, 12:01:45
    Author     : Sara Frisk
    Author     : Emma Rangert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <link rel="stylesheet" href="css.css" />

        <title>Kassan</title>
    </head>
    <body>
        
        <div id="check_out">
            <h1>Pizza Online</h1>
            <h3>Thanks for your order!</h3>
            
            <form action=PizzaShopServlet?action=shop method="post">
                <input type="submit" value="Back to the shop">
            </form>

        </div>
    </body>
</html>
