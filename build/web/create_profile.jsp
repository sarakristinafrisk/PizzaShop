<%-- 
    Document   : create_profile
    Created on : 2013-maj-13, 12:36:23
    Author     : sarafrisk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css.css" />

        <title>Create new profile</title>
        
    </head>
    <body>
        <div id="create_user">
            <h1>Pizza Online</h1>
            <h3>Skapa ny profil</h3>
            <form>
                <ul>
                    <li>
                        <label id="user_name">Användarnamn:</label>
                        <input type="text" name="user_name_input" id="user_name_input"/>
                    </li>
                    <li>
                        <label id="user_password">Lösenord:</label>
                        <input type="text" name="user_password_input" id="user_password_input"/>
                    </li>
                    <li>
                        <label id="user_firstname">Namn:</label>
                        <input type="text" name="user_firstname_input" id="user_firstname_input"/>
                    </li>
                    <li>
                        <label id="user_surname">Efternamn:</label>
                        <input type="text" name="user_surname_input" id="user_surname_input"/>
                    </li>
                    <li>
                        <label id="user_email">E-mail:</label>
                        <input type="text" name="user_email_input" id="user_email_input"/>
                    </li>
                    <li>
                        <label id="user_address">Adress:</label>
                        <input type="text" name="user_address_input" id="user_address_input"/>
                    </li>
                    <li>
                        <label id="user_postcode_input">Postnummer:</label>
                        <input type="text" name="user_postcode_input" id="user_postcode_input"/>
                    </li>
                    <li>
                        <label id="user_city">Stad:</label>
                        <input type="text" name="user_city_input" id="user_city_input"/>
                    </li>
                    <li>
                        <label id="user_country">Land:</label>
                        <input type="text" name="user_contry_input" id="user_contry_input"/>
                    </li>
                    <li>
                        <input class="create_user_button" type="submit" value="Logga in">
                    </li>
                </ul>   
            </form>

        </div>
    </body>
</html>
