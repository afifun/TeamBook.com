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
				<h2 class="heading">Step 2 : Informasi Pengiriman</h2>
			</div>


			<div class="shopper-informations">
				<div class="row">	
					<div class="col-lg-12">
						<div class="shopper-info">
							<form action="CheckoutStep2" method="POST">
                                                            <table>
                                                                <tbody>
                                                                    <tr>
                                                                        <td>Perusahaan Kurir</td>
                                                                        <td>:</td>
                                                                        <td><strong>PenToLine</strong></td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Jenis Servis</td>
                                                                        <td>:</td>
                                                                        <td> <select class="form-control" id="sel3" name="paket">
                                                                                <option value="Normal">Normal</option>
                                                                                <option value="Jumbo">Jumbo</option>
                                                                                <option value="Express">Express</option>
                                                                            </select>
                                                                        </td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Waktu Penerimaan Paket</td>
                                                                        <td>:</td>
                                                                        <td> <select class="form-control" id="sel3" name="waktu">
                                                                                <option value="00:00">00:00</option>
                                                                                <option value="01:00">01:00</option>
                                                                                <option value="02:00">02:00</option>
                                                                                <option value="03:00">03:00</option>
                                                                                <option value="04:00">04:00</option>
                                                                                <option value="05:00">05:00</option>
                                                                                <option value="06:00">06:00</option>
                                                                                <option value="07:00">07:00</option>
                                                                                <option value="08:00">08:00</option>
                                                                                <option value="09:00">09:00</option>
                                                                                <option value="10:00" selected>10:00</option>
                                                                                <option value="11:00">11:00</option>
                                                                                <option value="12:00">12:00</option>
                                                                                <option value="13:00">13:00</option>
                                                                                <option value="14:00">14:00</option>
                                                                                <option value="15:00">15:00</option>
                                                                                <option value="16:00">16:00</option>
                                                                                <option value="17:00">17:00</option>
                                                                                <option value="18:00">18:00</option>
                                                                                <option value="19:00">19:00</option>
                                                                                <option value="20:00">20:00</option>
                                                                                <option value="21:00">21:00</option>
                                                                                <option value="23:00">23:00</option>
                                                                                <option value="24:00">24:00</option>
                                                                            </select> 
                                                                        </td>
                                                                        <td>&nbsp;&nbsp; <b>WIB<b></td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
								<input style="width: 17%;" class="btn btn-primary pull-right" type="submit" value="Continue >>">
							</form> 
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
                                                <tr>
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
