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
    <title>Konfirmasi | Teambook</title>
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
					<div class="signup-form" ><!--sign up form-->
						<h2>Konfirmasi Pembayaran</h2>  
                                                <p style="color: red">${notifikasi}</p>
						<form action="Konfirmasi" method="post" enctype="multipart/form-data">
                                                    <label>ID Order</label>
                                                    <input type="text" value="${IDOrder}" name="id_order" placeholder="ID Order" readonly/>
						    <label>Upload Bukti Transfer</label>
                                                    <input class="form-control" placeholder="image.jpg" type="file"
                                               name="bukti_transfer" value="" accept="image/*">
                                                    <p></p>
						    <button type="submit" class="btn btn-default">Konfirmasi</button>
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
