<%-- 
    Document   : create_profile
    Created on : 2013-maj-13, 12:36:23
    Author     : Sara Frisk
    Author     : Emma Rangert
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
            <h3>Create new profile</h3>
            <form action=PizzaShopServlet?action=createProfileCheck method="post">
                <ul>
                    <li>
                        <label id="user_name">Username:</label>
                        <input type="text" name="user_name_input"/>
                    </li>
                    <li>
                        <label id="user_password">Password</label>
                        <input type="text" name="user_password_input" id="user_password_input"/>
                    </li>
                    <li>
                        <label id="user_firstname">Firstname:</label>
                        <input type="text" name="user_firstname_input" id="user_firstname_input"/>
                    </li>
                    <li>
                        <label id="user_surname">Lastname:</label>
                        <input type="text" name="user_surname_input" id="user_surname_input"/>
                    </li>
                    <li>
                        <label id="user_email">E-mail:</label>
                        <input type="text" name="user_email_input" id="user_email_input"/>
                    </li>
                    <li>
                        <label id="user_address">Address:</label>
                        <input type="text" name="user_address_input" id="user_address_input"/>
                    </li>
                    <li>
                        <label id="user_postcode_input">Postcode:</label>
                        <input type="text" name="user_postcode_input" id="user_postcode_input"/>
                    </li>
                    <li>
                        <label id="user_city">City:</label>
                        <input type="text" name="user_city_input" id="user_city_input"/>
                    </li>
                    <li>
                        <label id="user_country">Country:</label>
                        <input type="text" name="user_country_input" id="user_contry_input"/>
                    </li>
                    <li>
                        <input class="create_user_button" type="submit" value="Save">
                    </li>
                </ul>   
            </form>

        </div>
    </body>
</html>
