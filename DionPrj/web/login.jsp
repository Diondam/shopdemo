<%-- 
    Document   : login
    Created on : Feb 25, 2023, 4:17:08 PM
    Author     : diond
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Login Page</title>
        <jsp:include page="includeBoostrap.jsp"/>
    </head>

    <body>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-1"><jsp:include page="menu.jsp"/></div>
                <div class="col-sm-11"> 
                    <div class="containerD">
                        <div class="block_center">
                            <h1>Mời bạn login!</h1><br>

                            <form action="login" method="post">
                                <div>
                                    <label for="name">Hảo hán tên gì</label>
                                    <input type="text" name="name" id="name">
                                </div>

                                <div>
                                    <label for="pass">Pass của hảo hán</label>
                                    <input type="password" name="pass" id="pass">
                                </div>
                                <div>${sessionScope.error}</div>
                                <div>
                                    <input type="submit" name="Login" value="Login"
                                           style="width: 60px; height: 30px">
                                </div> 
                                <br>
                                <div><a href="forget">Quên Mật Khẩu</a></div>
                                <div><a href="newacc">Tài Khoản Mới</a></div>
                            </form>
                        </div>
                        <div style="background-color: #4bffa5; padding: 30px; border-radius: 10px; text-align: left">
                            <c:if test="${requestScope.newacc==1}" >
                                <form action="newacc" method="post">
                                    <div>
                                        <label for="name">Hảo hán tên gì</label>
                                        <input type="text" name="name" id="name">
                                    </div>

                                    <div>
                                        <label for="pass">Pass của hảo hán</label>
                                        <input type="password" name="pass" id="pass">
                                    </div>
                                    <div>
                                        <label for="rePass">Nhập lại pass</label>
                                        <input type="password" name="repass" id="rePass">
                                    </div>
                                    <div>
                                        <label for="email">Nhập Email</label>
                                        <input type="text" name="email" id="email">
                                    </div>
                                    <div>
                                        <label for="add">Nhập Address</label>
                                        <input type="text" name="add" id="add">
                                    </div>

                                    <div>
                                        <label for="phone">Nhập Phonenumber</label>
                                        <input type="text" name="phone" id="phone">
                                    </div>

                                    <div>
                                        <input type="submit" name="create" value="Create"
                                               style="width: 60px; height: 30px">
                                    </div> 
                                    <br> 
                                    <h3>${requestScope.repassW}</h3>
                                </form>
                            </c:if>
                            <c:if test="${requestScope.forget==1}" >
                                <form action="forget" method="post">

                                    <div>
                                        <label for="userRe">Nhập lại Username</label>
                                        <input type="text" name="userRe" id="userRe">
                                    </div>
                                    <div>
                                        <label for="emailRe">Nhập lại Email</label>
                                        <input type="text" name="emailRe" id="emailRe">
                                    </div>
                                    <div>
                                        <input type="submit" name="send" value="Send"
                                               style="width: 60px; height: 30px">
                                    </div> 
                                    <br>   
                                    
                                </form>
                            </c:if>
                        </div>



                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
