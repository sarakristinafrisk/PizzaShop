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
            <h3>Logga in</h3>
            <form>
                <ul>
                    <li>
                        <label id="is_admin">Admin:</label>
                        <input type="checkbox" id="is_admin_input"/>
                    </li>
                    
                    <li>
                        <label id="user_name">Användarnamn:</label>
                        <input type="text" name="user_name_input" id="user_name_input"/>
                    </li>
                    <li>
                        <label id="user_password">Lösenord:</label>
                        <input type="text" name="user_password_input" id="user_password_input"/>
                    </li>

                    <li>
                        <input class="login_button" type="button" value="Skapa ny användare"/>
                        <input class="login_button" type="submit" value="Logga in">
                    </li>
                </ul>   
            </form>

        </div>
    </body>
</html>
