<%-- 
    Document   : login_error
    Created on : 2013-maj-30, 12:57:50
    Author     : emmarangert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css.css" />
        <title>Error when logging in</title>
    </head>
    <body>
        <h3>Something of the following went wrong:</h3>
        <ul>
            <li>Wrong password or username</li>
            <li>Username and password already exist</li>
            <li>Reason unkown...</li>
        </ul>
        <a href="login.jsp">Try again!</a>
    </body>
</html>
