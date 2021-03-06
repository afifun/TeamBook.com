<%-- 
    Document   : checkout
    Created on : Mar 11, 2015, 5:08:53 PM
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
        <title>Edit Buku | Teambook</title>
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
                <!--			<div class="breadcrumbs">
                                                <ol class="breadcrumb">
                                                  <li><a href="#">Home</a></li>
                                                  <li class="active">Tambah Buku</li>
                                                </ol>
                                        </div>/breadcrums-->

                <div class="row">  	
                    <div class="col-sm-8">
                        <div class="contact-form">
                            <h2 class="title text-center">Edit Buku</h2>
                            
                            <div class="status alert alert-success" 
                                 <c:if test="${notifikasi == null}">style="display: none"</c:if> >
                            ${notifikasi}
                            </div>
                                 
                            <form id="main-contact-form" action="EditBook" class="contact-form row" name="contact-form" method="post" enctype="multipart/form-data">
                                <input type="hidden" name="id" value="${bukuobj.getId()}" class="form-control" required="required" placeholder="Judul">
                                
                                <div class="form-group col-lg-6">
                                    <input type="text" name="judul" value="${bukuobj.getJudul()}" class="form-control" required="required" placeholder="Judul">
                                </div>
                                
                                <div class="form-group col-lg-6">
                                    <input type="date" name="tanggal_terbit" value="${bukuobj.getPublishDate()}" class="form-control"  required="required" placeholder="Tanggal Terbit">
            
                                </div>
    
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <select class="form-control" name="kategori">
                                            <option value="">-- pilih kategori --</option>
                                            <option value="Fiksi"
                                                    <c:if test="${bukuobj.getKategori() == 'Fiksi'}">selected</c:if>
                                                    >Fiksi</option>
                                            <option value="Non Fiksi"<c:if test="${bukuobj.getKategori() == 'Non Fiksi'}">selected</c:if>>Non Fiksi</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <input type="text" name="isbn" value="${bukuobj.getIsbn()}" class="form-control" required="required" placeholder="ISBN" > 
                                </div>
                                
                                <div class="col-lg-12"></div>
                                  
                                <div class="form-group col-lg-6">
                                    <input type="text" name="pengarang" value="${bukuobj.getAuthor()}" class="form-control" required="required" placeholder="Pengarang"> 
                                </div>
                                <div class="form-group col-lg-6">
                                    <input type="text" name="penerbit" value="${bukuobj.getPenerbit()}" class="form-control" required="required" placeholder="penerbit"> 
                                </div>

                                <div class="form-group col-md-12">
                                    <textarea name="deskripsi" id="message" required="required" class="form-control" rows="8" placeholder="Tulis Deskripsi Buku Disini!">${bukuobj.getDeskripsi()}</textarea>
                                </div>
                                
                                <div class="form-group col-lg-6">
                                    <input type="text" name="stok" value="${bukuobj.getStok()}" class="form-control" required="required" placeholder="stok"> 
                                </div>
                                <div class="form-group col-lg-6">
                                    <input type="text" name="berat" value="${bukuobj.getBerat()}" class="form-control" required="required" placeholder="berat"> 
                                </div>
                                
                                <div class="col-lg-6">
                                    <input type="text" name="harga" value="${bukuobj.getHarga()}" class="form-control" required="required" placeholder="harga"> 
                                </div>
                                
                                <div class="col-lg-6">
                                    <div class="form-group" data-role="input-control">
                                        <input class="form-control" placeholder="image.jpg" type="file"
                                               name="gambar" value="${bukuobj.getGambar()}" accept="image/*">
                                    </div>
                                </div>
                                
                                <div class="col-lg-6 pull-right">
                                    <img style="height:60px;width: 60px;" src="${bukuobj.getGambar()}">
                                </div>
                                
                                
                                <div class="form-group col-md-12">
                                    <input type="submit" name="submit" class="btn btn-primary pull-right" value="Simpan">
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-sm-4">

                    </div>    			
                </div>
            </div>
        </section> <!--/#cart_items-->



        <!--<footer id="footer">
            <div class="footer-top">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="companyinfo">
                                <h2><span>e</span>-shopper</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,sed do eiusmod tempor</p>
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img src="images/home/iframe1.png" alt="" />
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Circle of Hands</p>
                                    <h2>24 DEC 2014</h2>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img src="images/home/iframe2.png" alt="" />
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Circle of Hands</p>
                                    <h2>24 DEC 2014</h2>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img src="images/home/iframe3.png" alt="" />
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Circle of Hands</p>
                                    <h2>24 DEC 2014</h2>
                                </div>
                            </div>

                            <div class="col-sm-3">
                                <div class="video-gallery text-center">
                                    <a href="#">
                                        <div class="iframe-img">
                                            <img src="images/home/iframe4.png" alt="" />
                                        </div>
                                        <div class="overlay-icon">
                                            <i class="fa fa-play-circle-o"></i>
                                        </div>
                                    </a>
                                    <p>Circle of Hands</p>
                                    <h2>24 DEC 2014</h2>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="address">
                                <img src="images/home/map.png" alt="" />
                                <p>505 S Atlantic Ave Virginia Beach, VA(Virginia)</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="footer-widget">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>Service</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">Online Help</a></li>
                                    <li><a href="">Contact Us</a></li>
                                    <li><a href="">Order Status</a></li>
                                    <li><a href="">Change Location</a></li>
                                    <li><a href="">FAQ’s</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>Quock Shop</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">T-Shirt</a></li>
                                    <li><a href="">Mens</a></li>
                                    <li><a href="">Womens</a></li>
                                    <li><a href="">Gift Cards</a></li>
                                    <li><a href="">Shoes</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>Policies</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">Terms of Use</a></li>
                                    <li><a href="">Privecy Policy</a></li>
                                    <li><a href="">Refund Policy</a></li>
                                    <li><a href="">Billing System</a></li>
                                    <li><a href="">Ticket System</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="single-widget">
                                <h2>About Shopper</h2>
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="">Company Information</a></li>
                                    <li><a href="">Careers</a></li>
                                    <li><a href="">Store Location</a></li>
                                    <li><a href="">Affillate Program</a></li>
                                    <li><a href="">Copyright</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-3 col-sm-offset-1">
                            <div class="single-widget">
                                <h2>About Shopper</h2>
                                <form action="#" class="searchform">
                                    <input type="text" placeholder="Your email address" />
                                    <button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
                                    <p>Get the most recent updates from <br />our site and be updated your self...</p>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <div class="footer-bottom">
                <div class="container">
                    <div class="row">
                        <p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>
                        <p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p>
                    </div>
                </div>
            </div>

        </footer>-->
        
        <jsp:include page="footer.jsp" flush="false" />


        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
