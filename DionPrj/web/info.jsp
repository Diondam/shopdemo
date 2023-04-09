<%-- 
    Document   : info
    Created on : Feb 25, 2023, 5:31:18 PM
    Author     : diond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info Page</title>
    </head>
    <body>
        <div style="display: flex; flex-direction: row;">
            <div><jsp:include page="menu.jsp"/></div> 

            <div style="margin-left: 200px">
                <h1>Your Infomation</h1>
                <h2>name: ${sessionScope.account.name}</h2>
                <h2>pass: ${sessionScope.account.pass}</h2>
                <h2>role: ${sessionScope.account.role}</h2>

            </div>
        </div>




    </body>
</html>
