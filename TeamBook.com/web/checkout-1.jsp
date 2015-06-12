<%-- 
    Document   : checkout
    Created on : Mar 11, 2015, 5:08:53 PM
    Author     : moh.afifun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Checkout | Teambook</title>
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
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Check out</li>
				</ol>
			</div><!--/breadcrums-->
                        
				<div class="row">
                        <div class="col-lg-6">
                            
			<div class="step-one">
				<h2 class="heading">Step 1 : Informasi Penerima*</h2>
			</div>


			<div class="shopper-informations">
				<div class="row">	
					<div class="col-lg-12">
						<div class="shopper-info">
							<form>
                                                            <table>
                                                                <tbody>
                                                                    <tr>
                                                                        <td>Nama</td>
                                                                        <td>: <strong>${currentAkun.getNama()}</strong></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Provinsi</td>
                                                                        <td>: <strong>${currentAkun.getProvinsi()}</strong></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Kota</td>
                                                                        <td>: <strong>${currentAkun.getKota()}</strong></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Kode Pos</td>
                                                                        <td>: <strong>${currentAkun.getKodePos()}</strong></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Alamat Pengiriman </td>
                                                                        <td>: <strong>${currentAkun.getAlamatShipping()}</strong></td>
                                                                    </tr>
                                                                    
                                                                </tbody>
                                                                
                                                            </table>
								
							</form>
                                                                    <br>
                                                                    <p style="font-size: 12px"><i><b>*)</b> Data yang digunakan berdasarkan profil, pastikan data pada profil sudah benar.</i></p>
                                                    <a class="btn btn-primary pull-right" href="CheckoutStep2">Continue >></a>
						</div>
					</div>				
				</div>
			</div>
                        </div>
                                    <div class="col-lg-3"></div>
                        <div class="col-lg-3">
                            
                            <div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Checkout Progress</td>
						</tr>
                                                
					</thead>
					<tbody>
                                            <tr >
                                                    <td class="cart_product">
                                                        <strong>1. Informasi Penerima</strong>
                                                    </td>
                                                            
                                                </tr>
                                                <tr style="color: grey">
                                                    <td class="cart_product">
                                                        <strong>2. Informasi Pengiriman</strong>
                                                    </td>
                                                            
                                                </tr>
                                                <tr style="color: grey">
                                                    <td class="cart_product">
                                                        <strong>3. Informasi Pembayaran</strong>
                                                    </td>
                                                            
                                                </tr>
                                                
					</tbody>
				</table>
                            </div>
                        </div>
                      </div>
		</div>
	</section> <!--/#cart_items-->
        <jsp:include page="footer.jsp" flush="false" />

    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>
