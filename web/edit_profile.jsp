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
                <ul>
                    <li>
                        <label id="user_name">Username:</label>
                        <input type="text" name="user_name_input" disabled="disabled" value="<jsp:getProperty name='currentUser' property='username'/>"/>
                    </li>
                    <li>
                        <label id="user_password">Password</label>
                        <input type="text" name="edit_user_password_input" id="edit_user_password_input" value="<jsp:getProperty name='currentUser' property='password'/>"/>
                    </li>
                    <li>
                        <label id="user_firstname">Firstname:</label>
                        <input type="text" name="edit_user_firstname_input" id="edit_user_firstname_input" value="<jsp:getProperty name='currentUser' property='firstname'/>"/>
                    </li>
                    <li>
                        <label id="user_surname">Lastname:</label>
                        <input type="text" name="edit_user_surname_input" id="edit_user_surname_input" value="<jsp:getProperty name='currentUser' property='surname'/>"/>
                    </li>
                    <li>
                        <label id="user_email">E-mail:</label>
                        <input type="text" name="edit_user_email_input" id="edit_user_email_input" value="<jsp:getProperty name='currentUser' property='email'/>"/>
                    </li>
                    <li>
                        <label id="user_address">Address:</label>
                        <input type="text" name="edit_user_address_input" id="edit_user_address_input" value="<jsp:getProperty name='currentUser' property='address'/>"/>
                    </li>
                    <li>
                        <label id="user_postcode_input">Postcode:</label>
                        <input type="number" name="edit_user_postcode_input" id="edit_user_postcode_input" value=<jsp:getProperty name='currentUser' property='postcode'/> />
                    </li>
                    <li>
                        <label id="user_city">City:</label>
                        <input type="text" name="edit_user_city_input" id="edit_user_city_input" value="<jsp:getProperty name='currentUser' property='city'/>"/>
                    </li>
                    <li>
                        <label id="user_country">Country:</label>
                        <input type="text" name="edit_user_country_input" id="edit_user_contry_input" value="<jsp:getProperty name='currentUser' property='country'/>"/>
                    </li>
                    <li>
                        <input class="create_user_button" type="submit" value="Save">
                    </li>
                </ul>   
            </form>

        </div>
    </body>
</html>
