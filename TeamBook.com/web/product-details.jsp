<%-- 
    Document   : product-details
    Created on : Mar 11, 2015, 5:09:52 PM
    Author     : moh.afifun
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Product Details | Teambook</title>
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
	<section>
		<div class="container">
			<div class="row">
				
				<div class="col-sm-9 padding-right">
					<div class="product-details"><!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="${buku_detil.getGambar()}" alt="" />
								<h3>ZOOM</h3>
							</div>
							

						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<img src="" class="newarrival" alt="" />
								<h2>${buku_detil.getJudul()}</h2>
								<p>Web ID: ${buku_detil.getId()}</p>
								<img src="images/product-details/rating.png" alt="" />
								<span>
									<span>Rp. ${buku_detil.getHarga()}</span>
									<label>Quantity:</label>
									<input type="text" value="3" />
                                                                        <a href="AddToCart?id=${buku_detil.getId()}"><button type="button" class="btn btn-fefault cart">
										<i class="fa fa-shopping-cart"></i>
										Add to cart
									</button></a>
								</span>
								<p><b>Availability:</b> In Stock</p>
								<a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>
                                                                <h2></h2>
                                                                <p><b>Deskripsi:</b></p>
                                                                <p>${buku_detil.getDeskripsi()}</p>
                                                        </div><!--/product-information-->
                                                        
						</div>
					</div><!--/product-details-->
					
					
					<div class="recommended_items"><!--recommended_items-->
						<h2 class="title text-center">Buku Lainnya</h2>
						
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">
                                                                    
                                                                    <c:forEach var="item" items="${buku_list}">
                                                                        <div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="${item.getGambar()}" alt="" />
													<h2>Rp. ${item.getHarga()}</h2>
													<a href="DetilBuku?id=${item.getId()}"><p>${item.getJudul()}</p></a>
                                                                                                        <a href="AddToCart?id=${item.getId()}"><button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button></a>
												</div>
											</div>
										</div>
									</div>
                                                                    </c:forEach>
									
								</div>
								<div class="item">	
									<c:forEach var="item" items="${buku_list}">
                                                                        <div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="${item.getGambar()}" alt="" />
													<h2>Rp. ${item.getHarga()}</h2>
                                                                                                        <a href="DetilBuku?id=${item.getId()}"><p>${item.getJudul()}</p></a>
                                                                                                        <a href="AddToCart?id=${item.getId()}"><button type="button" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</button></a>
												</div>
											</div>
										</div>
									</div>
                                                                    </c:forEach>
								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div><!--/recommended_items-->
					
				</div>
			</div>
		</div>
	</section>
	
        <jsp:include page="footer.jsp" flush="false" />

  
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
</body>
</html>
