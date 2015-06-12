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
						<form action="Register" method="post">
                                                        <input type="text" name="nama" placeholder="Nama" required/>
                                                        <input type="text" name="username" placeholder="Username" required/>
							<input type="email" name="email" placeholder="Email" required/>
							<input type="password" name="password" placeholder="Password" required/>
                                                        <input type="text" name="phone" placeholder="No.Telepon" required/>
							<select class="form-control" id="sel2" name="provinsi">
                                                            <option value="">-- Provinsi --</option>
                                                            <option value="Jakarta">Jakarta</option>
                                                            <option value="Banten">Banten</option>
                                                            <option value="Jawa Barat">Jawa Barat</option>
                                                            
                                                        </select>
                                                        <br>
							<select class="form-control" id="sel2" name="kota">
                                                            <option value="">-- Kota --</option>
                                                            <option value="Jakarta">Jakarta</option>
                                                            <option value="Depok">Depok</option>
                                                            <option value="Bogor">Bogor</option>
                                                            <option value="Tangerang">Tangerang</option>
                                                            <option value="Bekasi">Bekasi</option>
                                                        </select>
                                                        <br>
							<input type="text" name="kode_pos" placeholder="Kode Pos" required/>
                                                        <textarea rows="5" name="alamat_default" placeholder="Alamat Tetap" required></textarea>
                                                        <p></p>
                                                        <textarea rows="5" name="alamat_shipping" placeholder="Alamat Shipping" required></textarea>
                                                        <p></p>
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
