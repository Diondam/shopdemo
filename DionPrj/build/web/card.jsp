<%-- 
    Document   : card
    Created on : Mar 1, 2023, 5:59:06 PM
    Author     : diond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
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
                        <c:if test="${sessionScope.account.role==2}">
                            <h1>FOR SELLER</h1>
                            <a href="#" class="text-mid">Các sản phẩm của bạn</a>&nbsp;&nbsp;&nbsp;
                            <a href="#" class="text-mid">Khách Order</a>
                        </c:if>

                        <c:if test="${sessionScope.account.role==3}">
                            <h1 style="font-size: 2em; margin-top: 20px;">CÁC SẢN PHẨM BẠN SẼ THANH TOÁN</h1>
                        </c:if>
                    </div>

                    <!--tạo ra 1 chuỗi product temp rồi truyền sang đây-->
                    <!--from gửi id pro và quatity về-->
                    <form action="card" method="post">
                        <table>
                            <th>Num</th>
                            <th>Tên sản phẩm</th>
                            <th>Số lượng</th>
                            <th>Giá</th>
                            <th>Bỏ Order</th>
                            <c:forEach items="${requestScope.proArrTemp}" var="pro" varStatus="i">
                                <tr>
                                    <td class="text-mid">${i.index+1}</td>
                                    <td>${pro.name}</td>
                                    <td class="text-mid"><input type="number" id="quantity" name="quantity" 
                                                                min="1" max="5" step="1" value="${pro.quantity}"></td>
                                    <td>${pro.price}</td>
                                    <td class="text-mid"><a href="delpro?delid=${pro.id}">Delete</a></td>
                                <input type="hidden"  name="id" value="${pro.id}">
                                </tr>
                            </c:forEach>
                        </table>
                        <br><br>
                        <c:if test="${!ok}">
                        <div style="display: flex; justify-content: center">
                            <input id="add" type="submit" name="name" style="width: 15vw" value="BUY NOW">
                        </div>
                         </c:if>
                    </form>
                </div>
                
                <!--phần bên phải-->
                <div class ="col-sm-4" style="background-color: #9ef7e6">
                    <c:if test="${ok}">
                        <div style="text-align: center;margin-top: 20px; "><h3>Order thành công</h3></div>
                        <table>
                            <th>*</th>
                            <th>Giá</th>
                            <c:set var="priceTemp" value="0"/>
                            <c:forEach items="${requestScope.proArrTemp}" var="pro">
                                <tr>
                                    <td>${pro.name}</td>
                                    <td>${pro.price*pro.quantity}</td>
                                    
                                </tr>
                            </c:forEach>
                        </table>
                            <div><h1>${priceTemp}</h1></div>
                    </c:if>

     
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
