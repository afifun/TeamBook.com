<%-- 
    Document   : index
    Created on : Mar 11, 2015, 5:09:23 PM
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
    <title>Home | Teambook</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
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
	<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>
						
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1><span>Teambook</span>Store</h1>
									<h2>Promo bulan April</h2>
									<p></p>
									<!--<button type="button" class="btn btn-default get">Dapatkan Promo</button>-->
                                                                        <button type="button" class="btn btn-default add-to-cart">Dapatkan Promo</button> <!-- pakai class nya ini biar buttonnya kayak add to cart -->
                                                                </div>
								<div class="col-sm-6">
									<img style="margin-left:100px ; width:300px;height: 400px" src="images/home/baca1.jpg" class="girl img-responsive" alt="" />
									<!--<img src="images/home/pricing.png"  class="pricing" alt="" />-->
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">

									<h1><span>Teambook</span>Store</h1>
									<h2>Buku Terlaris</h2>
									<p></p>
									<!--<button type="button" class="btn btn-default get">Beli Buku</button>-->
                                                                        <button type="button" class="btn btn-default add-to-cart">Dapatkan Promo</button> <!-- pakai class nya ini biar buttonnya kayak add to cart -->
								</div>
								<div class="col-sm-6">
									<img style="margin-left: 100px ; width:300px;height: 400px" src="images/home/baca2.jpg" class="girl img-responsive" alt="" />
									<!--<img src="images/home/pricing.png"  class="pricing" alt="" />-->
								</div>
							</div>
							
							<div class="item">
								<div class="col-sm-6">
									<h1><span>Teambook</span>Store</h1>
									<h2>Buku Terlaris</h2>
									<p></p>
                                                                        <button type="button" class="btn btn-default">Dapatkan Promo</button> <!-- pakai class nya ini biar buttonnya kayak add to cart -->
								</div>
								<div class="col-sm-6">
									<img style="margin-left: 100px;width:300px;height: 400px" src="images/home/buku1.jpg" class="girl img-responsive" alt="" />
								</div>
							</div>
							
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Daftar Buku</h2>
                                                <c:forEach var="item" items="${listBuku}">
                                                    <div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
                                                                                    <a href="DetilBuku?id=${item.getId()}"><img  style="width:150px;height: 200px" src="${item.getGambar()}" alt="" /></a>
                                                                                   	
                                                                                    <h2><fmt:setLocale value="id_ID"/>
                                                                                        <fmt:formatNumber value="${item.getHarga()}" type="currency"/>
                                                                                  
                                                                                        </h2>
                                                                                        <a href="DetilBuku?id=${item.getId()}"><p>${item.getJudul()}</p></a>
											<a href="AddToCart?id=${item.getId()}" class="btn btn-default"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                                                </div>
                                                                </div>
                                                        </div>
                                                    </div>
                                                                                        
                                                </c:forEach>
                                        </div>
                                </div>
                        </div>
                </div>
        </section>
                    
                                                    
        <jsp:include page="footer.jsp" flush="false" />
