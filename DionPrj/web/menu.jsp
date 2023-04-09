<%-- 
    Document   : menu
    Created on : Feb 25, 2023, 3:58:31 PM
    Author     : diond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            nav {
                display: flex;
                flex-direction: column;
                /*background-color: #f2f2f2;*/
                background-color: #825287;
                /*padding: 20px;*/
                width: 70px;
                /*width: 1vw;*/
                height: 100vh;
                border-radius: 17px;
                position: fixed;
            }

            nav a {
                color: #4bffa5;
                text-decoration: none;
                padding: 10px;
                margin-right: 5px;
                margin-left: 5px;
                margin-bottom: 10px;
                border-radius: 5px;
                transition: background-color 0.3s ease-in-out;
            }

            nav a:hover {
                background-color: #4bffa5;
                color: black;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <nav>
            <img src="images/faviconX.ico" style="border-radius: 10px;margin-top: 10px" width="100%" height="70px%"/>
            <a href="home">Home</a>&nbsp;&nbsp;
            <c:if test="${sessionScope.account.role==2}">
                <a href="sell">Seller</a>&nbsp;&nbsp;
            </c:if>

            <c:if test="${sessionScope.account.role==3}">
                <a href="card">Card</a>&nbsp;&nbsp;
            </c:if>
            <c:if test="${sessionScope.account!=null}">
                <a href="info">${sessionScope.account.name}</a>&nbsp;&nbsp; 
                <a href="logout">Logout</a>&nbsp;&nbsp; 
            </c:if>

            <c:if test="${sessionScope.account==null}">
                <a href="login">Login</a>&nbsp;&nbsp;
            </c:if>

            <c:if test="${sessionScope.account.role==1}">
                <a href="admin">Admin</a>&nbsp;&nbsp;
            </c:if>


        </nav>
    </body>
</html>
