<%-- 
    Document   : seller
    Created on : Mar 13, 2023, 7:05:51 PM
    Author     : diond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <style>
            table, th, td {
                border: 1px solid white;
                border-radius: 7px;
                border-collapse: collapse;
            }
            th, td {
                background-color: #96D4D4;
            }
            th{
                text-align: center;
            }
            table{
                width: 100%;
                border-radius: 10px;
                margin-top: 20px;
            }
            #add{
                display: inline;
                margin-top: 10px;
                border-radius: 0px 0px 8px 8px;
                background-color: #4bffa5;
                border: 1px solid activecaption;
                text-align: center;
                text-decoration: none;
            }
            .text-mid{
                text-align: center;
            }

            .newpro div{
                margin: 15px;
            }
            .newpro div input{
                border-radius: 5px;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class= "row">
                <div class="col-sm-1">
                    <jsp:include page="menu.jsp"/>
                </div>
                <div class ="col-sm-6" style="background-color: azure">
                    <div>
                        <h1>FOR SELLER</h1>
                        <a href="sell" class="text-mid">Sản Phẩm</a>&nbsp;&nbsp;&nbsp;
                        <a href="ordersell" class="text-mid">Khách Order</a>
                    </div>

                    <table>
                        <th>Num</th>
                        <th>Tên sản phẩm</th>
                        <th>Số lượng</th>
                        <th>Giá</th>
                        <th>Edit</th>
                        <th>Delete</th>

                        <c:forEach items="${pro}" var="pro" varStatus="i">
                            <c:if test="${(pro.sellid==sessionScope.account.id)}" >
                                <tr>
                                    <td class="text-mid">${count=count +1}</td>
                                    <td>${pro.name}</td>
                                    <td class="text-mid"><input type="number" id="quantity" name="quantity" min="1" max="5" step="1" value="${pro.quantity}"></td>
                                    <td>${pro.price}</td>
                                    <td><a href="editpro?id=${pro.id}">Edit</a></td>
                                    <td class="text-mid"><a href="delprosell?delid=${pro.id}">Delete</a></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                    <br><br>

                </div>

                <!--phần bên phải-->
                <div class ="col-sm-4" style="background-color: #9ef7e6">

                    <c:if test="${edit}">
                        <div><h3>Edit sản phẩm</h3></div>
                        <div class="newpro">
                            <form action="editpro" method="post">
                                <div><input type="text" name="name" placeholder="name" value='${p.name}'></div>
                                <div><input type="number" min="0" name="quantity"value='${p.quantity}'placeholder="quantity"></div>
                                <div><input type="number" min="0" name="price" value='${p.price}'placeholder="price"></div>
                                <div><textarea id="id" placeholder="description" name="description" rows="5" cols="50">${p.description}</textarea></div>
                                <div><input type="text" name="img" value='${p.img}'placeholder="link ảnh"></div>
                                <div><input type="hidden" name="cateID" value='${p.cateID}'></div>
                                <div><input type="hidden" name="proID"  value='${p.id}'></div>
                                <div><input type="hidden" name="sellid"  value='${p.sellid}'></div>
                                <div><select id="id" name="cate" >
                                        <c:forEach items="${catelist}" var="c">
                                            <option value="first" ${(c.id==p.cateID?"selected":"")}>${(c.name)}</option>
                                        </c:forEach>
                                    </select></div>
                                <div><input type="submit" name="submit" value="SAVE"></div>

                            </form>
                        </div>
                    </c:if>
                    <c:if test="${!edit}">
                        <div><h3>Tạo sản phẩm mới</h3></div>
                        <div class="newpro">
                            <form action="newpro" method="post">
                                <div><input type="text" name="name" placeholder="name" value='${p.name}'></div>
                                <div><input type="number" min="0" name="quantity"value='${p.quantity}'placeholder="quantity"></div>
                                <div><input type="number" min="0" name="price" value='${p.price}'placeholder="price"></div>
                                <div><textarea id="id" placeholder="description" name="description" rows="5" cols="50">${p.description}</textarea></div>
                                <div><input type="text" name="img" value='${p.img}'placeholder="link ảnh"></div>
                                <!--<div><input type="hidden" name="cateID" value='${p.cateID}'></div>-->
                                <!--<div><input type="hidden" name="proID"  value='${sessionScope.account.id}'></div>-->
                                <div><input type="hidden" name="sellid"  value='${sessionScope.account.id}'></div>
                                <div><select id="id" name="cateID" >
                                        <c:forEach items="${catelist}" var="c">
                                            <option value="${c.id}" ${(c.id==p.cateID?"selected":"")}>${(c.name)}</option>
                                        </c:forEach>
                                    </select></div>
                                <div><input type="submit" name="submit" value="SAVE"></div>

                            </form>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
