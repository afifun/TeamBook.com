<%-- 
    Document   : login
    Created on : Mar 11, 2015, 5:09:32 PM
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
    <title>Informasi Akun | Teambook</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
   
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
						<h2>Informasi Akun</h2>  
                                                <p style="color: red">${notifikasi}</p>
						<form action="DetilAkun" method="post">
                                                        <input type="hidden" name="id" value="${akun.getId()}"/>
                                                        <input type="text" name="nama" value="${akun.getNama()}" placeholder="Nama" required/>
                                                        <input type="text" name="username" value="${akun.getUsername()}" placeholder="Username" required/>
							<input type="email" name="email" value="${akun.getEmail()}"placeholder="Email" required/>
							<input type="password" name="password" value="${akun.getPassword()}" placeholder="Password" required/>
                                                        <input type="text" name="phone" value="${akun.getPhone()}" placeholder="No.Telepon" required/>
                                                        <select class="form-control" id="sel2" name="provinsi" required="">
                                                            <option value="">-- Provinsi --</option>
                                                            <option value="Jakarta" <c:if test="${akun.getProvinsi() == 'Jakarta'}"> selected </c:if>>Jakarta</option>
                                                            <option value="Banten" <c:if test="${akun.getProvinsi() == 'Banten'}"> selected </c:if>>Banten</option>
                                                            <option value="Jawa Barat" <c:if test="${akun.getProvinsi() == 'Jawa Barat'}"> selected </c:if>>Jawa Barat</option>
                                                            
                                                        </select>
                                                        <br>
                                                        <select class="form-control" id="sel2" name="kota" required="">
                                                            <option value="">-- Kota --</option>
                                                            <option value="Jakarta" <c:if test="${akun.getKota() == 'Jakarta'}"> selected </c:if>>Jakarta</option>
                                                            <option value="Depok" <c:if test="${akun.getKota() == 'Depok'}"> selected </c:if>>Depok</option>
                                                            <option value="Bogor" <c:if test="${akun.getKota() == 'Bogor'}"> selected </c:if>>Bogor</option>
                                                            <option value="Tangerang" <c:if test="${akun.getKota() == 'Tangerang'}"> selected </c:if>>Tangerang</option>
                                                            <option value="Bekasi" <c:if test="${akun.getKota() == 'Bekasi'}"> selected </c:if>>Bekasi</option>
                                                        </select>
                                                        <br>
							<input type="text" name="kode_pos" value="${akun.getKodePos()}" placeholder="Kode Pos" required/>
                                                        <textarea rows="5" name="alamat_default" placeholder="Alamat Tetap" required>${akun.getAlamatDefault()}</textarea>
                                                        <p></p>
                                                        <textarea rows="5" name="alamat_shipping" placeholder="Alamat Shipping" required>${akun.getAlamatShipping()}</textarea>
                                                        <p></p>
							<button type="submit" class="btn btn-default">Simpan</button>
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
