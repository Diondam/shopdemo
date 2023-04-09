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
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-1">
                    <jsp:include page="menu.jsp"/>
                </div>
                <div class="col-sm-5">
                    <h1 class="header-text">  USER</h1>
                    <table style="background-color: #ccfce4; ">
                        <th>&nbsp; # &nbsp; </th>
                        <th>Role</th>
                        <th>Name</th>
                        <th>Password</th>
                        <th>Mail</th>
                        <th>Send Mail</th>
                        <th>To Seller</th>
                        <th>Delete</th>

                        <c:forEach items="${requestScope.us}" var="us" varStatus="i">
                            <tr>
                                <td>${i.index+1}</td>
                                <c:if test="${us.role==2}" >
                                    <td><i>Seller</i></td>
                                </c:if>
                                <c:if test="${us.role==3}" >
                                    <td>Client</td>
                                </c:if>
                                <c:if test="${us.role==1}" >
                                    <td><b>Admin</b></td>
                                </c:if>
                                <td>${us.name}</td>
                                <td>${us.pass}</td>
                                <td>${us.email}</td>
                                <td><a href="adminmail?email=${us.email}">Send Mail</a></td>
                                <c:if test="${us.role==3}" >
                                    <td><a href="tosell?id=${us.id}">To Seller</a></td>
                                </c:if>
                                <c:if test="${us.role!=3}" >
                                    <td><b></b></td>
                                </c:if>
                                <td><a href="deluser?id=${us.id}">Delete</a></td>

                            </tr>
                        </c:forEach>



                    </table>
                </div>
                <div class="col-sm-5">
                    <h1 class="header-text">  SELLER</h1>

                    <table style="background-color: #adf8ff">
                        <th>#</th>
                        <th>Name</th>
                        <th>Password</th>
                        <th>Send Mail</th>
                        <th>Dekete</th>


                        <c:forEach items="${requestScope.us}" var="us" varStatus="j">
                            <c:if test="${us.role==2}" >
                                <tr>
                                    <td>${j.index+1}</td>
                                    <td>${us.name}</td>
                                    <td>${us.pass}</td>
                                    <td>${us.email}</td>
                                    <td><a href="adminmail?email=${us.email}">Send Mail</a></td>
                                    <td><a href="deluser?id=${us.id}">Delete</a></td>
                                </tr>
                            </c:if>

                        </c:forEach>



                    </table>
                </div>
                <div class="col-sm-1" style="border-radius: 20px;background-color: #825287; height: 100vh">
                    <h4><a href="proadmin">Manager Product</a></h4>
                    <h4><a href="orderadmin">Manager Order</a></h4>

                </div>


            </div>
        </div>
    </body>
</html>
