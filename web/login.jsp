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

        <title>Logga in</title>
    </head>
    <body>
        
        <div id="login">
            <h1>Pizza Online</h1>
            <h3>Log in</h3>
            <form action=PizzaShopServlet?action=loginCheck method="post" >

                <ul>
                    <li>
                        <label id="is_admin">Admin:</label>
                        <input type="checkbox" name="is_admin_input" id="is_admin_input"/>
                    </li>
                    
                    <li>
                        <label id="user_name">Username:</label>
                        <input type="text" name="user_name_input" id="user_name_input"/>
                    </li>
                    <li>
                        <label id="user_password">Password:</label>
                        <input type="text" name="user_password_input" id="user_password_input"/>
                    </li>

                    <li>                    
                        <input class="login_button" type="submit" value="Log in">
                    </li>
                </ul>   
            </form>
           
            <form action=PizzaShopServlet?action=createProfile method="post">
                <input class="login_button" type="submit" value="Create new user">
                You can't create a new admin!
            </form>
            

        </div>
    </body>
</html>
