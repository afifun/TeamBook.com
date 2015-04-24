<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<header id="header"><!--header-->

    <!--    <div class="header_top">header_top
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="contactinfo">
                            <ul class="nav nav-pills">
                                <li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
                                <li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="social-icons pull-right">
                            <ul class="nav navbar-nav">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>/header_top-->

    <div class="header-middle"><!--header-middle-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="logo pull-left">
                        <a href="index.jsp"><img src="images/home/logobaru2.png" alt="" /> 
                            <c:if test="${currentSessionUser.isIsAdmin()}">
						Admin
					</c:if>
                            </a>
                    </div>
                    <!--                    <div class="btn-group pull-right">
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                                                    USA
                                                    <span class="caret"></span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a href="#">Canada</a></li>
                                                    <li><a href="#">UK</a></li>
                                                </ul>
                                            </div>
                    
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                                                    DOLLAR
                                                    <span class="caret"></span>
                                                </button>
                                                <ul class="dropdown-menu">
                                                    <li><a href="#">Canadian Dollar</a></li>
                                                    <li><a href="#">Pound</a></li>
                                                </ul>
                                            </div>
                                        </div>-->
                </div>
                <div class="col-sm-8">
                    <div class="shop-menu pull-right">
                        <ul class="nav navbar-nav">

                            <c:choose>
                                <c:when test="${currentSessionUser != null}">
                                    <li><a href="#"><i class="fa fa-user"></i> ${currentSessionUser.getNama()}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                    <li><a href="#"><i class="fa fa-user"></i> Account</a></li>
                                    </c:otherwise>
                                </c:choose>	

                            <li><a href="checkout.jsp"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                            <li><a href="Cart"><i class="fa fa-shopping-cart"></i> Cart${item_sum}</a></li>


                            <c:choose>
                                <c:when test="${currentSessionUser != null}">
                                    <li><a href="Logout"><i class="fa fa-unlock"></i> Logout</a></li>
                                    </c:when>
                                    <c:otherwise>
                                    <li><a href="login.jsp"><i class="fa fa-lock"></i> Login</a></li>
                                    </c:otherwise>
                                </c:choose>		     
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header-middle-->

    <div class="header-bottom"><!--header-bottom-->
        <div class="container">
            <div class="row">
                <div class="col-sm-9">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="mainmenu pull-left">
                        <ul class="nav navbar-nav collapse navbar-collapse">

                            <c:choose>
                                <c:when test="${currentSessionUser.isIsAdmin()}">
                                    <li><a href="Index" class="active"
                                           <c:if test="${home}"> class="active" </c:if>>Home</a></li>
                                    <li><a href="ListBook"
                                        <c:if test="${buku}"> class="active" </c:if>>
                                            Buku
                                        </a>
                                    </li>
                                    <li><a href="ListAkun" <c:if test="${akun}"> class="active" </c:if>>
                                            Akun
                                        </a>
                                    </li>
                                    <li><a href="contact-us.jsp"
                                           <c:if test="${contact}"> class="active" </c:if>
                                           >Contact</a></li>
                                    </c:when>
                                    <c:otherwise>
                                    <li><a href="Index" class="active"
                                           <c:if test="${home}"> class="active" </c:if>>Home</a></li>
                                    <li><a href="ListBook"
                                        <c:if test="${buku}"> class="active" </c:if>>
                                            Buku
                                        </a>
                                    </li>
                                    <li><a href="contact-us.jsp"
                                           <c:if test="${contact}"> class="active" </c:if>
                                           >Contact</a></li>
                                    </c:otherwise>
                                </c:choose>

                        </ul>
                    </div>
                </div>
                <!--                <div class="col-sm-3">
                                    <div class="search_box pull-right">
                                        <input type="text" placeholder="Search"/>
                                    </div>
                                </div>-->
            </div>
        </div>
    </div><!--/header-bottom-->
</header><!--/header-->
