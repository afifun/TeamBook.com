<%-- 
    Document   : shop
    Created on : Mar 11, 2015, 5:10:19 PM
    Author     : moh.afifun
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Shop | TeamBookStore</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head><!--/head-->

    <body>

        <jsp:include page="header.jsp" flush="false" />

        <section>
            <div class="container">
                <div class="row">

                    <div class="col-sm-12">
                        <div class="features_items"><!--features_items-->
                            <h2 class="title text-center">Daftar Buku</h2>
                            <c:forEach var="item" items="${list_buku}">
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a href="DetilBuku?id=${item.getId()}"><img  style="width:150px;height: 200px" src="${item.getGambar()}" alt="" /></a>
                                                <h2> <fmt:setLocale value="id_ID"/>
                                                    <fmt:formatNumber value="${item.getHarga()}" type="currency"/></h2>
                                                <a href="DetilBuku?id=${item.getId()}"><p>${item.getJudul()}</p></a>

                                                <a href="AddToCart?id=${item.getId()}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>

                                            </div>

                                        </div>
                                    </div>
                                </div>

                            </c:forEach>



                        </div><!--features_items-->

                        <ul class="pagination pull-right">
                            <c:choose>
                                <c:when test="${page < 3}">
                                    <li 
                                        <c:if test="${page == 0}">class="active"</c:if>
                                        ><a href="Shop?page=0">1</a></li>
                                    <li <c:if test="${page == 1}">class="active"</c:if>><a href="Shop?page=1">2</a></li>
                                    <li <c:if test="${page == 2}">class="active"</c:if>><a href="Shop?page=2">3</a></li>
                                    <li><a href="Shop?page=${page+1}">&raquo;</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="Shop?page=0">${page - 1}</a></li>
                                    <li><a href="Shop?page=1">${page}</a></li>
                                    <li class="active"><a href="Shop?page=2">${page + 1}</a></li>
                                    <li><a href="Shop?page=${page + 2}">&raquo;</a></li>
                                </c:otherwise>
                            </c:choose>
                            
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp" flush="false" />
    </body>
</html>