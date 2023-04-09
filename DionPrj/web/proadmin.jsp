<%-- 
    Document   : proadmin
    Created on : Mar 14, 2023, 9:20:58 AM
    Author     : diond
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="includeBoostrap.jsp"/>
        <style>
            table{
                width: 100%;
                border-radius: 10px;
            }
            .header-text{
                font-size: 40px;
                color: mediumvioletred;
                font: bold;
                text-align: center;
            }
            th{
                /*text-align: center;*/
            }
            h4:hover{
                border-radius: 10px;
                background: #4bffa5
            }
            h4:hover >a{
                text-decoration: none;
                color: black;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-1">
                    <jsp:include page="menu.jsp"/>
                </div>
                <%!int coun = 0;%>                        <%! int count=0; %>
                <div class="col-sm-10" style="background-color: #96D4D4">
                    <h1 class="header-text">  PRODUCT</h1>
                    <table style="background-color: #ccfce4; width: 100%">
                        <th>&nbsp; # &nbsp; </th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Category</th>
                        <th>Seller</th>
                        <th>Date</th>
                            <c:set value="${seller}" var="seller" />
                            <c:forEach items="${catePro}" var="cp" varStatus="i" >
                                <c:set value="${seller[i.index]}" var="s"/>
                            <tr>
                                <td>${i.index+1}</td>
                                <td>${cp.key.name}</td>
                                <td>${cp.key.price}</td>
                                <td>${cp.key.quantity}</td>
                                <td>${cp.value}</td>
                                <td>${s}</td>
                                <td>${cp.key.date}</td>
                            </tr>
                        </c:forEach>



                    </table>
                </div>

                <div class="col-sm-1" style="background-color: #825287; height: 100vh ; border-radius: 20px">
                    <h4><a href="admin">Manager User</a></h4>
                    <h4><a href="proadmin">Manager Product</a></h4>
                    <h4><a href="orderadmin">Manager Order</a></h4>
                </div>


            </div>
        </div>
    </body>
</html>
