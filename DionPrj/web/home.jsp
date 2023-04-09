

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"/>
        <jsp:include page="includeBoostrap.jsp"/>
        <title>Home Page</title>
        <link rel="icon" type="image/x-icon" href="images/favicon.ico">


        <style>
            .sanpham{
                width: 200px;
                height: 305px;
                display: flex;
                flex-direction: column;
                background-color: pink;
                border-radius: 10px;
                margin-bottom: 30px;
                border: 2px solid #4bffa5;
            }
            img{
                border-radius: 10px 10px 0px 0px;
                border-bottom: 3px solid crimson;
            }
            p{
                margin: 0px;
            }
            .buttu:hover{
                background-color: rgba(204,245,252,1);
            }
            .buttu:checked{

                background-color: rgba(204,245,252,1);
                color: green;

            }
            .buttu{
                margin-top: 10px;
                border-radius: 0px 0px 10px 10px;
                background-color: #4bffa5;
                border: 1px solid activecaption;
            }

            .header-text{
                font-size: 40px;
                /*color: mediumvioletred;*/
                color: white;

                font: bold;
                position: fixed;
                margin-top: 5px;
                font: bold;
            }
            #add{
                display: inline-block;
                /*margin-top: 30px;*/
                border-radius: 0px 0px 10px 10px;
                background-color: #4bffa5;
                border: 1px solid #00f7ff;
                text-align: center;
                text-decoration: none;
            }
            #add:hover{
                background-color: #00f7ff;
                color: #ff2667;
            }
            .category{
                background-color: rgba(108,69,113, 0.3);
                border-left: 10px;
                border-radius: 10px;
            }
            .category > a{
                text-decoration: none;
                color: #4bffa5;
            }


            .fixed-bottom {
                position: fixed;
                bottom: 0;
                left: 0;
                width: 100%;
                background-color: #34ebe5;
                display: flex;
                flex-direction: row;
                justify-content: center;
                background: rgba(44, 191, 159, 0.5);
                margin: 0px 130px 0px 130px;
                border-radius: 25px;
            }
            .fixed-bottom > div{
                width: 50px;
            }
            .pagingA{
                width: 50px;
                background-color: rgba(255, 95, 107, 0.1);
                border-radius: 5px;
                margin: 2px 30px 2px 10px;
                text-align: center;
                text-decoration: none;
                color: white;
            }
            .pagingA:hover{
                background-color: rgba(255, 95, 107, 0.7);
            }
        </style>
    </head>

    <body>
        <script>
            fuction addCard(){
                const link = document.getElementById("add");
                link.href =
            }
            //    linear-gradient(90deg, rgba(247,189,255,1) 0%, rgba(175,208,255,1) 64%, rgba(0,255,243,1) 100%);
        </script>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-2 col-xl-1" style=""><jsp:include page="menu.jsp"/></div>
                <div class="col-sm-10 col-xl-11" style="border-radius: 25px; background: #825287"> 
                    <div class="header-text" style="display: flex; background-color: rgba(108,69,113, 0.3); border-radius: 10px;">
                        <div>MỜI BẠN MUA CÁC SẢN PHẨM BÊN DƯỚI</div>&nbsp;&nbsp;&nbsp;
                        <div class="category">
                            <c:forEach items="${catelist}" var="cc">
                                <a style="font-size: 30px; "href="#">${cc.name}</a>
                            </c:forEach>
                        </div>
                    </div>
                    <br><br>
                    &nbsp;&nbsp;
                    <div style="display: flex; flex-wrap: wrap ;
                         justify-content: space-around;">

                        <c:forEach items="${pro}" var="prod" begin="${page.begin}" end="${page.end}">
                            <div class="sanpham">
                                <img src=${prod.img} width="196px" height="200px" alt="alt"/>
                                <div><p style="height:  48px">&nbsp;<b>${prod.name}</b></p></div>
                                <div><p> &nbsp;Giá: <b>${prod.price}$</b>&nbsp;&nbsp;Quantity: <b>${prod.quantity}</b></p></div>
                                <a id="add" href="addcard?id=${prod.id}&user=${sessionScope.account.id}">ADD+</a>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </div>
        <div class="fixed-bottom">
            <c:if test="${page.index!=0}" >
                <a class="pagingA" href='home?nrpp=${page.nrpp}&index=0'>Home</a>
                <a  class="pagingA" href='home?nrpp=${page.nrpp}&index=${page.index-2}'>Pre</a>
            </c:if>  

            <c:forEach var="p" begin="${0}" end ="${page.totalPage-1}">
                <a class="pagingA" href='home?nrpp=${page.nrpp}&index=${p}'>${p+1}</a>
            </c:forEach>

            <c:if test="${page.index!= page.totalPage-1}">
                <a class="pagingA" href='home?nrpp=${page.nrpp}&index=${page.index+2}'>Next</a>
                <a  class="pagingA" href='home?nrpp=${page.nrpp}&index=${page.totalPage-1}'>End</a> 
            </c:if>
        </div>

    </body>
    <script>
        // Store current scroll position in local storage before unloading the page
        window.addEventListener('beforeunload', function () {
            localStorage.setItem('scrollPosition', window.pageYOffset);
        });

        // Set scroll position to the stored value after page has finished loading
        window.addEventListener('load', function () {
            var scrollPosition = localStorage.getItem('scrollPosition');
            if (scrollPosition !== null) {
                window.scrollTo(0, scrollPosition);
                localStorage.removeItem('scrollPosition');
            }
        });

    </script>
</html>
