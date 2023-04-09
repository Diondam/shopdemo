<%-- 
    Document   : maiForUser
    Created on : Mar 13, 2023, 6:01:19 PM
    Author     : diond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mail Page</title>
    </head>
    <body>
        <h1>Mail Page | to ${requestScope.email}</h1>
        <form action="adminmail" method="post">
            <input type="hidden" name="email" value="${requestScope.email}">
            <textarea name="content" rows="8" cols="100"></textarea>
            <div><input type="submit" name="name" value="Send Mail"></div>
        </form>
    </body>
</html>
