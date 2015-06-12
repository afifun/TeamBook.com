<%-- 
    Document   : login
    Created on : Mar 11, 2015, 5:09:32 PM
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
    <title>Register | Teambook</title>
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
		<div class="container">
			<div class="row">
				<div class="col-sm-4 ">
					<div class="signup-form"><!--sign up form-->
						<h2>Register</h2>  
                                                <p style="color: red">${notifikasi}</p>
						<form action="EditCheckout" method="post">
                                                        <label>ID</label>
                                                        <input type="text" name="ID" value="${checkout.getId()}" placeholder="ID" readonly/>
                                                        <label>Tanggal</label>
                                                        <input type="text" name="Tanggal" value="${checkout.getTanggal()}" readonly/>
							<label>ID Akun</label>
                                                        <input type="text" name="nama" value="${checkout.getIdAkun()}" readonly/>
                                                        <label>Kurir</label>
                                                        <input type="text" name="username" value="${checkout.getNamaKurir()}" readonly/>
                                                        <label>Jenis Paket</label>
                                                        <input type="text" name="nama" value="${checkout.getJenisPaket()}" readonly/>
                                                        <label>Biaya Pengiriman</label>
                                                        <input type="text" name="username" value="${checkout.getBiayaPengiriman()}" readonly/>
							<label>Biaya Buku</label>
                                                        <input type="text" name="nama" value="${checkout.getBiayaItem()}" readonly/>
                                                        <label>Bank</label>
                                                        <input type="text" name="username" value="${checkout.getBank()}" readonly/>
							<label>Status</label>
                                                        <input type="text" name="nama" value="${checkout.getId()}" readonly/>
                                                        <label> Konfirmasi<input type="checkbox" name="konfirmasi" value="3" /></label>
                                                        <br>
                                                        <label>Bukti Transfer</label>
                                                        <br>
                                                        <img style="width: 90%;height: 90%;" src="${bukti_transfer.getGambarPath()}"/>
                                                        <br>
							<button type="submit" class="btn btn-default">Register</button>
						</form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	
	
	<jsp:include page="footer.jsp" flush="false" />
	

  
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>
