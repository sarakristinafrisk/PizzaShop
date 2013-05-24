<%-- 
    Document   : create_profile
    Created on : 2013-maj-13, 12:36:23
    Author     : Sara Frisk
    Author     : Emma Rangert
--%>

<%@page import="beans.ProfileBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css.css" />

        <title>Edit profile</title>
        
    </head>
    <body>
        <div id="create_user">
            <h1>Pizza Online</h1>
            <h3>Edit profile</h3>
            <form action=PizzaShopServlet?action=editProfileCheck method="post">
                
                
                <jsp:useBean id="currentUser" class="beans.ProfileBean" scope="application"/>
Inloggad: <c:out value="${currentUser.getUsername()}"/>
                                
                <ul>
                    <li>
                        <label id="user_name">Username:</label>
                        <input type="text" name="user_name_input" disabled="disabled" value="${currentUser.getUsername()}"/>
                    </li>
                    <li>
                        <label id="user_password">Password</label>
                        <input type="text" name="edit_user_password_input" id="edit_user_password_input" value="${currentUser.getPassword()}"/>
                    </li>
                    <li>
                        <label id="user_firstname">Firstname:</label>
                        <input type="text" name="edit_user_firstname_input" id="edit_user_firstname_input" value="${currentUser.getFirstname()}"/>
                    </li>
                    <li>
                        <label id="user_surname">Lastname:</label>
                        <input type="text" name="edit_user_surname_input" id="edit_user_surname_input" value="${currentUser.getSurname()}"/>
                    </li>
                    <li>
                        <label id="user_email">E-mail:</label>
                        <input type="text" name="edit_user_email_input" id="edit_user_email_input" value="${currentUser.getEmail()}"/>
                    </li>
                    <li>
                        <label id="user_address">Address:</label>
                        <input type="text" name="edit_user_address_input" id="edit_user_address_input" value="${currentUser.getAddress()}"/>
                    </li>
                    <li>
                        <label id="user_postcode_input">Postcode:</label>
                        <input type="text" name="edit_user_postcode_input" id="edit_user_postcode_input"value="${currentUser.getPostcode()}"/>
                    </li>
                    <li>
                        <label id="user_city">City:</label>
                        <input type="text" name="edit_user_city_input" id="edit_user_city_input" value="${currentUser.getCity()}"/>
                    </li>
                    <li>
                        <label id="user_country">Country:</label>
                        <input type="text" name="edit_user_country_input" id="edit_user_contry_input" value="${currentUser.getCountry()}"/>
                    </li>
                    <li>
                        <input class="create_user_button" type="submit" value="Save">
                    </li>
                </ul>   
            </form>

        </div>
    </body>
</html>
