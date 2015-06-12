    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 
    Document   : cart
    Created on : Mar 11, 2015, 5:08:17 PM
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
    <title>Cart | Teambook</title>
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
				  <li class="active">Checkout</li>
                                  
				</ol>
			</div>
                    <div class="review-payment">
				<h2>Konfirmasi Checkout</h2>
			</div>
                    
                    <div class="container">
			<div class="row">
                            <div class="col-sm-6">
                                    <h3>Penerima</h3>
                                <div class="total_area">
						<table>
                                                                <tbody>
                                                                    
                                                                    <tr>
                                                                        <td>Nama</td>
                                                                        <td>: <strong>${currentSessionUser.getNama()}</strong></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Provinsi</td>
                                                                        <td>: <strong>${currentSessionUser.getProvinsi()}</strong></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Kota</td>
                                                                        <td>: <strong>${currentSessionUser.getKota()}</strong></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Kode Pos</td>
                                                                        <td>: <strong>${currentSessionUser.getKodePos()}</strong></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Alamat Pengiriman </td>
                                                                        <td>: <strong>${currentSessionUser.getAlamatShipping()}</strong></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Waktu Penerimaan </td>
                                                                        <td>: <strong>${waktu_penerimaan}</strong>&nbsp;&nbsp;WIB</td>
                                                                    </tr>
                                                                    
                                                                </tbody>
                                                            </table>
			         </div>
                            </div>
                                                                    
                                                                    <div class="col-sm-6">
                                                                        <h3>Kurir</h3>
                                                                        
                                                                        <div class="total_area">
						<table >
                                                                <tbody>
                                                                    
                                                                    <tr>
                                                                        <td>Nama Perusahaan</td>
                                                                        <td>: <strong>${nama_kurir}</strong></td>
                                                                    </tr>
                                                                    
                                                                    <tr>
                                                                        <td>Jenis Paket</td>
                                                                        <td>: <strong>${jenis_paket}</strong></td>
                                                                    </tr>
                                                                    
                                                                </tbody>
                                                            </table>
			         </div>
                                                                    </div>
				
			</div>
		</div>
                                                                    <br>
                                                                    <br>
                                                                    
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Harga</td>
							<td class="quantity">Jumlah</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
                                            <c:set var="total" scope="session" value="${0}"/>
                                            <c:forEach var="item" items="${list}">
                                                <tr>
							<td class="cart_product">
								<a href=""><img style="height:50px;width: 50px;" src="${item.getBuku().getGambar()}" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">${item.getBuku().getJudul()}</a></h4>
								<p>${item.getBuku().getId()}</p>
							</td>
							<td class="cart_price">
								<p>
                                                                    <fmt:setLocale value="id_ID"/>
                                                                    <fmt:formatNumber value="${item.getBuku().getHarga()}" type="currency" />
                                                                </p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<input class="cart_quantity_input" type="text" name="quantity" value="${item.getKuantitas()}" autocomplete="off" size="2" readonly>
									
								</div>
							</td>
							<td class="cart_total">
                                                            
                                                                <c:set var="total" scope="session" value="${total + (item.getKuantitas()*item.getBuku().getHarga())}"/>
								<p class="cart_total_price"> <fmt:setLocale value="id_ID"/>
                                                                    <fmt:formatNumber value="${item.getKuantitas() * item.getBuku().getHarga()}" type="currency" />
                                                                </p>
							</td>
						</tr>
                                                
                                            </c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->
	<section id="do_action">
		<div class="container">
			<div class="row">
                            <div class="col-sm-6">
                            </div>
				<div class="col-sm-6">
                                    <h3></h3>
					<div class="total_area">
						<ul>
							<li>Total Keranjang <span> <fmt:setLocale value="id_ID"/>
                                                                    <fmt:formatNumber value="${total}" type="currency" />
                                                                </span></li>
							<li>Biaya Pengiriman <span> <fmt:setLocale value="id_ID"/>
                                                                    <fmt:formatNumber value="${biayapaket_total}" type="currency" />
                                                                </span></li>
							<li>Total <span> <fmt:setLocale value="id_ID"/>
                                                                    <fmt:formatNumber value="${total + biayapaket_total}" type="currency" />
                                                                </span></li>
                                                        <br>
                                                        <p>Transfer via Bank <strong>${nama_bank}</strong></p>
                                                        <p><i>Setelah checkout transaksi <b>tidak bisa dibatalkan.</b></i></p>
						</ul>
							<a class="btn btn-default update " href="UserCheckout">Checkout</a>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->

	
        <jsp:include page="footer.jsp" flush="false" />

    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>
