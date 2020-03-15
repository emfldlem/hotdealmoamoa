<%@ page import="com.emfldlem.hotdeal.Entity.HotdealEntity" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
    List<HotdealEntity> hotdealList = (List<HotdealEntity>) request.getAttribute("allList");

    SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분");
    String strToday = format2.format (System.currentTimeMillis());

%>
<!doctype html>
<html lang="en">
<head>
    <title>너굴의 핫딜 모아모아</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="icon" href="/images/favicon.ico">

    <link rel="stylesheet" href="/bootstrap/css/custom-bs.css">
    <link rel="stylesheet" href="/bootstrap/css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="/bootstrap/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="/bootstrap/fonts/icomoon/style.css">
    <link rel="stylesheet" href="/bootstrap/fonts/line-icons/style.css">
    <link rel="stylesheet" href="/bootstrap/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/bootstrap/css/animate.min.css">
    <link rel="stylesheet" href="/bootstrap/css/quill.snow.css">


    <!-- MAIN CSS -->
    <link rel="stylesheet" href="/bootstrap/css/style.css">
</head>

<body id="top">

<div id="overlayer"></div>
<div class="loader">
    <div class="spinner-border text-primary" role="status">
        <span class="sr-only">Loading...</span>
    </div>
</div>


<div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
        <div class="site-mobile-menu-header">
            <div class="site-mobile-menu-close mt-3">
                <span class="icon-close2 js-menu-toggle"></span>
            </div>
        </div>
        <div class="site-mobile-menu-body"></div>
    </div> <!-- .site-mobile-menu -->


    <!-- NAVBAR -->
    <header class="site-navbar mt-3">
        <div class="container-fluid">
            <div class="row align-items-center">
                <div class="site-logo col-6"><img src="/images/iconpng.png" alt="Image" style="width: 50px;height: 50px; margin-right: 10px;" class="img-fluid"><a href="/hotdeal/hotdealList">너굴의 핫딜 모아모아</a></div>

                <nav class="mx-auto site-navigation">
                    <ul class="site-menu js-clone-nav d-none d-xl-block ml-0 pl-0">
                        <li class="d-lg-none"><a href="#"><span class="mr-2">+</span> Post a Job</a></li>
                        <li class="d-lg-none"><a href="#">Log In</a></li>
                    </ul>
                </nav>

                <div class="right-cta-menu text-right d-flex aligin-items-center col-6">
                    <div class="ml-auto">
                        <a href="#" class="btn btn-outline-white border-width-2 d-none d-lg-inline-block"><span class="mr-2 icon-add"></span>Post a Job</a>
                        <a href="#" class="btn btn-primary border-width-2 d-none d-lg-inline-block"><span class="mr-2 icon-lock_outline"></span>Log In</a>
                    </div>
                    <a href="#" class="site-menu-toggle js-menu-toggle d-inline-block d-xl-none mt-lg-2 ml-3"><span class="icon-menu h3 m-0 p-0 mt-2"></span></a>
                </div>

            </div>
        </div>
    </header>

    <!-- HOME -->
    <section class="section-hero home-section overlay inner-page bg-image" style="padding-bottom: 0;" id="home-section"></section>


    <section class="site-section" id="next">
        <div class="container">

            <div class="row mb-5 justify-content-center">
                <div class="col-md-7 text-center">
                    <h2 class="section-title mb-2"><%=strToday%>기준</h2>
                </div>
            </div>

            <ul class="job-listings mb-5">
                <%for(HotdealEntity hotdeal : hotdealList )  { %>
                <li class="job-listing d-block d-sm-flex pb-3 pb-sm-0 align-items-center">
                    <a href="<%= "ruriweb".equals(hotdeal.getBoardSe()) ? "https://bbs.ruliweb.com/market/board/1020" : "http://www.ppomppu.co.kr/zboard/zboard.php?id=ppomppu" %>"></a>
                    <div class="job-listing-logo">
                        <% if("ruriweb".equals(hotdeal.getBoardSe())) { %>
                        <img src="/images/logo/ruliweb_bi.jpg" alt="Image" class="img-fluid">
                        <% } else { %>
                        <img src="/images/logo/ppomppu_bi.jpg" alt="Image" class="img-fluid">
                        <% }%>
                    </div>

                    <div class="job-listing-about d-sm-flex custom-width w-100 justify-content-between mx-4">
                        <div class="job-listing-position custom-width w-80 mb-5 mb-sm-0">
                            <h2><%=hotdeal.getSubject()%></h2>
                            <strong><%=hotdeal.getNo()%></strong>
                        </div>
                        <div class="job-listing-location mb-1 mb-sm-0 custom-width w-10">
                            <%if(hotdeal.getSubject().contains("종료")) {%>
                            <span class="badge badge-danger">Part Time</span>
                            <% } %>
                        </div>

                        <div class="job-listing-meta">
                            2020-03-16
                        </div>
                    </div>
                </li>
                <% } %>

            </ul>

            <div class="row pagination-wrap">
                <div class="col-md-6 text-center text-md-left mb-4 mb-md-0">
                    <span>Showing 1-7 Of 43,167 Jobs</span>
                </div>
                <div class="col-md-6 text-center text-md-right">
                    <div class="custom-pagination ml-auto">
                        <a href="#" class="prev">Prev</a>
                        <div class="d-inline-block">
                            <a href="#" class="active">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#">4</a>
                        </div>
                        <a href="#" class="next">Next</a>
                    </div>
                </div>
            </div>

        </div>
    </section>

    <section class="py-5 bg-image overlay-primary fixed overlay" style="background-image: url('/bootstrap/images/hero_1.jpg');">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-md-8">
                    <h2 class="text-white">Looking For A Job?</h2>
                    <p class="mb-0 text-white lead">Lorem ipsum dolor sit amet consectetur adipisicing elit tempora adipisci impedit.</p>
                </div>
                <div class="col-md-3 ml-auto">
                    <a href="#" class="btn btn-warning btn-block btn-lg">Sign Up</a>
                </div>
            </div>
        </div>
    </section>


    <footer class="site-footer">

        <a href="#top" class="smoothscroll scroll-top">
            <span class="icon-keyboard_arrow_up"></span>
        </a>

        <div class="container">
            <div class="row mb-5">
                <div class="col-6 col-md-3 mb-4 mb-md-0">
                    <h3>Search Trending</h3>
                    <ul class="list-unstyled">
                        <li><a href="#">Web Design</a></li>
                        <li><a href="#">Graphic Design</a></li>
                        <li><a href="#">Web Developers</a></li>
                        <li><a href="#">Python</a></li>
                        <li><a href="#">HTML5</a></li>
                        <li><a href="#">CSS3</a></li>
                    </ul>
                </div>
                <div class="col-6 col-md-3 mb-4 mb-md-0">
                    <h3>Company</h3>
                    <ul class="list-unstyled">
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Career</a></li>
                        <li><a href="#">Blog</a></li>
                        <li><a href="#">Resources</a></li>
                    </ul>
                </div>
                <div class="col-6 col-md-3 mb-4 mb-md-0">
                    <h3>Support</h3>
                    <ul class="list-unstyled">
                        <li><a href="#">Support</a></li>
                        <li><a href="#">Privacy</a></li>
                        <li><a href="#">Terms of Service</a></li>
                    </ul>
                </div>
                <div class="col-6 col-md-3 mb-4 mb-md-0">
                    <h3>Contact Us</h3>
                    <div class="footer-social">
                        <a href="#"><span class="icon-facebook"></span></a>
                        <a href="#"><span class="icon-twitter"></span></a>
                        <a href="#"><span class="icon-instagram"></span></a>
                        <a href="#"><span class="icon-linkedin"></span></a>
                    </div>
                </div>
            </div>

            <div class="row text-center">
                <div class="col-12">
                    <p class="copyright">
                        <small>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                            All rights reserved | This template is made with <i class="icon-heart text-danger" aria-hidden="true"></i> by
                            <a href="https://colorlib.com" target="_blank">Colorlib</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></small>
                    </p>
                </div>
            </div>
        </div>
    </footer>

</div>

<!-- SCRIPTS -->
<script src="/bootstrap/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/bootstrap/js/isotope.pkgd.min.js"></script>
<script src="/bootstrap/js/stickyfill.min.js"></script>
<script src="/bootstrap/js/jquery.fancybox.min.js"></script>
<script src="/bootstrap/js/jquery.easing.1.3.js"></script>

<script src="/bootstrap/js/jquery.waypoints.min.js"></script>
<script src="/bootstrap/js/jquery.animateNumber.min.js"></script>
<script src="/bootstrap/js/owl.carousel.min.js"></script>
<script src="/bootstrap/js/quill.min.js"></script>


<script src="/bootstrap/js/bootstrap-select.min.js"></script>

<script src="/bootstrap/js/custom.js"></script>


</body>
</html>