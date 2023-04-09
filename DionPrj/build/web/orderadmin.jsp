<%-- 
    Document   : Admin
    Created on : Mar 1, 2023, 11:38:06 PM
    Author     : diond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
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
                <div class="col-sm-10">
                    <h1 class="header-text">  ORDER</h1>
                    <table style="background-color: #ccfce4; ">
                        <th>&nbsp; # &nbsp; </th>
                        <th>Client</th>
                        <th>Product</th>
                        <th>Quatity</th>
                        <th>Shop</th>
                        <th>Date</th>


                        <c:forEach items="${order}" var="o" varStatus="i">
                            <tr>
                                <td>${i.index+1}</td>
                                <td>${o.nameCli}</td>
                                <td>${o.namePro}</td>
                                <td>${o.quatity}</td>
                                <td>${o.nameShop}</td>
                                <td>${o.date}</td>
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
