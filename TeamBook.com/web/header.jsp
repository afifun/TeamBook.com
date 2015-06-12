<%@page import="model.BukuKeranjang"%>
<%@page import="model.Keranjang"%>
<%@page import="model.Checkout"%>
<%@page import="java.util.List"%>
<%@page import="model.Akun"%>
<%@page import="dao.CheckoutDAO"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<header id="header"><!--header-->
    
    <%
        CheckoutDAO dao = new CheckoutDAO();
        Akun temp = (Akun) request.getSession().getAttribute("currentSessionUser");
    %>

    <div class="header-middle"><!--header-middle-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="logo pull-left">
                        <a href="Index"><img src="images/home/logobaru2.png" alt="" /> 

                            <c:if test="${currentSessionUser.getIsAdmin()}">
						Admin
			    </c:if>
                            </a>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="shop-menu pull-right">
                        <ul class="nav navbar-nav">

                            <c:choose>
                                <c:when test="${currentSessionUser != null}">
                                    <li><a href="
                                           <c:if test="${!currentSessionUser.getIsAdmin()}">DetilAkun?id=${currentSessionUser.getId()}</c:if>
                                           "><i class="fa fa-user"></i> ${currentSessionUser.getNama()}</a></li>
                                </c:when>
                            </c:choose>	

                            <c:choose>
                                <c:when test="${currentSessionUser != null}">
                                    <li>
                                        <c:choose>
                                <c:when test="${currentSessionUser.getIsAdmin()}">
                                    <a href="ListCheckoutAdmin"><i class="fa fa-crosshairs"></i>Daftar Pesanan Pelanggan
                                        <% 
                                        List<Checkout> list = dao.getListCheckout();
                                        int count = 0;
                                        
                                        for(Checkout item: list){
                                            if (item.getStatus() == 1){
                                                count++;
                                            }
                                        }
                                        
                                        out.println("("+ count +")");
                                        
                                        %>
                                    
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="ListCheckout?id=${currentSessionUser.getId()}"><i class="fa fa-crosshairs"></i> Lihat Pesanan
                                    <% 
                                        List<Checkout> list2 = dao.getCheckoutByAkun(""+temp.getId());
                                        int counter = 0;
                                        
                                        for(Checkout item: list2){
                                            if (item.getStatus() == 1){
                                                counter++;
                                            }
                                        }
                                        
                                        out.println("("+ counter +")");
                                        
                                        %>
                                    </a>
                                    
                                      <li><a href="Cart"><i class="fa fa-shopping-cart"></i> Cart
                                        <%
                                        Keranjang keranjangTmp = (Keranjang) request.getSession().getAttribute("currentSessionCart");

                                        List<BukuKeranjang> listItem = keranjangTmp.getItemsKeranjang();
                                        int total = 0;
                                        for (BukuKeranjang list1 : listItem) {
                                                total = total + list1.getKuantitas();
                                        }
                                        
                                        out.println("("+ total +")");
                                            
                                        %>
                                        </a></li>
                                </c:otherwise>
                            </c:choose>
                                            </li>
                                  
                                </c:when>
                            </c:choose>

                            <c:choose>
                                <c:when test="${currentSessionUser != null}">
                                    <li><a href="Logout"><i class="fa fa-unlock"></i> Logout</a></li>
                                    </c:when>
                                    <c:otherwise>
                                    
                                    <li><a href="Register"><i class="fa fa-pencil-square"></i> Register</a></li>
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
                                <c:when test="${currentSessionUser.getIsAdmin()}">
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
                                    <li><a href="Shop?page=0"
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
            </div>
        </div>
    </div><!--/header-bottom-->
</header><!--/header-->
