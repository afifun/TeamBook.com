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
        <title>List Book | Teambook</title>
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

        <!-- DataTables CSS -->
        <link rel="stylesheet" type="text/css" href="DataTables/media/css/jquery.dataTables.css">

        <!-- jQuery -->
        <script type="text/javascript" charset="utf8" src="DataTables/media/js/jquery.js"></script>

        <!-- DataTables -->
        <script type="text/javascript" charset="utf8" src="DataTables/media/js/jquery.dataTables.js"></script>
        
        <script>
            $(document).ready(function () {
                $('#table_id').DataTable();
            });
        </script>

    </head><!--/head-->

    <body>
        <jsp:include page="header.jsp" flush="false" />
        <section id="cart_items">
            <div class="container">

                <div class="row">  	
                    <div class="col-md-12">
                        <div class="contact-form">
                            <h2 class="title text-center">Daftar Buku</h2>
                            <div class="status alert alert-success" 
                                 <c:if test="${notifikasi == null}">style="display: none"</c:if>
                                 >${notifikasi}</div>
                                 <a href="AddBook"><button class="btn btn-primary pull-right" style="margin-bottom: 3%"><span class="glyphicon-plus"></span> Tambah Buku</button></a>
                                 
                                 <table id="table_id" class="display" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>ISBN</th>
                                        <th>Judul</th>
                                        <th>Kategori</th>
                                        <th>Deskripsi</th>
                                        <th>Harga</th>
                                        <th>Gambar</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="item" items="${listBuku}">
                                        <tr>
                                            <td>${item.getIsbn()}</td>
                                            <td>${item.getJudul()}</td>
                                            <td>${item.getKategori()}</td>
                                            <td>${item.getDeskripsi()}</td>
                                            <td>${item.getHarga()}</td>
                                            <td>
                                                <img style="height:50px;width: 50px;" src="${item.getGambar()}"></td>
                                            <td>
                                                <a href="EditBook?id=${item.getId()}"><button class="btn btn-primary"><span class="glyphicon-pencil"></span> Edit</button></a>
                                                <a href="Delete?id=${item.getId()}"><button class="btn btn-primary"><span class="glyphicon-trash"></span> Delete</button></a>
                                            </td>
                                        </tr>   
                                    </c:forEach>
                                    
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-sm-4">

                    </div>    			
                </div>
            </div>
        </section> <!--/#cart_items-->


<jsp:include page="footer.jsp" flush="false" />

       
    </body>
</html>
