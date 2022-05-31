<%-- 
    Document   : index
    Created on : May 30, 2022, 12:29:03 PM
    Author     : SE150437 Vo Pham Quoc Thang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
            />
        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
            />
        <!-- MDB -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.1.0/mdb.min.css"
            rel="stylesheet"
            />
        <script
            type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.1.0/mdb.min.js"
        ></script>
        <title>Job Detail</title>
    </head>
    <body>
        <div>
            <div style="
                 background-color: #FC8902;
                 display: flex;
                 justify-content: left;
                 align-items: center;
                 padding: 25px 10vw;">
                <div class="text-light px-2" style="font-size: 15px;">
                    <span class="text-dark">
                        <i class="far fa-envelope"></i>
                    </span> daihoc.hcm@fpt.edu.vn
                </div>
                <div class="text-light px-2"  style="font-size: 15px;">
                    <span class="text-dark">
                        <i class="fas fa-phone"></i>
                    </span>
                    (028) 7300 5588
                </div>  
                <div style="    position: absolute;
                     right: 1vw;">
                    <button style="width: 10vw; border-radius: 20px !important ; padding: 10px"  class="btn btn-light shadow border fw-bold border border-dark">
                        <img 
                            style="    position: absolute;
                            left: 1vw;"
                            src="https://www.freepnglogos.com/uploads/google-logo-png/google-logo-png-google-icon-logo-png-transparent-svg-vector-bie-supply-14.png" 
                            width="20px" 
                            alt="google logo png google icon logo png transparent svg vector bie supply" />
                        <!--                    <span class="text-dark">
                                                <i class="fab fa-google"></i>
                                            </span>-->
                        login</button>
                </div>
            </div>
            <nav style="padding: 3vh 10vw " class="navbar navbar-expand-lg bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img style="height: 80px; align-items: center;" src="https://cdn.haitrieu.com/wp-content/uploads/2021/10/Logo-Dai-hoc-FPT.png"/>
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon">
                            <i class="fas fa-bars"></i>
                        </span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                        <ul class="navbar-nav ">
                            <li class="nav-item">
                                <a class="nav-link text-dark " aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark" aria-current="page" href="#">OJT</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark" aria-current="page" href="#">CNH</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark" aria-current="page" href="#">Company Tour</a>
                            </li>
                        </ul>
                        <form class="d-flex" role="search">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>  
            <div style="
                 display: flex;
                 justify-content: space-around;
                 align-items: center;
                 padding: 25px 1vw;">
                <div>
                    <span></span>
                </div>
            </div>
        </div>
        
            <div style="
                 display: flex;
                 justify-content: space-around;
                 align-items: center;
                 padding: 25px 1vw;">
                <span style="font-size: 30px; font-weight:bold;">
                    ${jobDetail.companyDetail.companyName}
                </span>
            </div>
            <hr style="height: 2px; color: black;"/>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-4">
                        <img style="height: 70%; align-items: center; position: absolute; padding-left: 100px; padding-bottom: 200px"  src="https://scontent.fsgn5-5.fna.fbcdn.net/v/t1.6435-9/96390018_2696615493801270_8485826556134948864_n.png?_nc_cat=100&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=jfQvr3P7PPkAX8zMuYJ&_nc_ht=scontent.fsgn5-5.fna&oh=00_AT_BIEXxQrEsLNBnweMlukjHUyjIegSZHwc1B3Mg0JGSwQ&oe=62BB7CE0"/>
                    </div>
                    <div class="col-8">
                        <p style="font-size: 30px; font-weight:bold; padding-top: 70px;">
                            <c:forEach items="${companyDes}" var="o">
                                ${o}<br>
                            </c:forEach>
                            ${jobDetail.companyDetail.companyAdress}<br>
                        </p>
                    </div>
                </div>
            </div>
            <div style="padding: 50px">
                <h3>Job description:</h3>
                <ul style="font-size: 25px">
                    <c:forEach items="${jobDes}" var="o">
                        <li>${o}</li>
                    </c:forEach>
                </ul>
            </div>
            <div style="padding: 50px">
                <h3>Qualification:</h3>
                <ul style="font-size: 25px">
                    <c:forEach items="${jobRe}" var="o">
                        <li>${o}</li>
                    </c:forEach>
                </ul>
            </div>
    </body>
    <footer>
        <div style="
             display: flex;
             justify-content: left;
             align-items: center;
             padding: 10px 10vw;">
            <div style="padding-left: 200px">
                <button style="width: 15vw; border-radius: 20px !important ; padding: 10px; background-color: #FC8902; color: white; border: hidden ">
                    APPLY
                </button>
            </div> 
            <div style="padding-left: 300px">
                <button style="width: 15vw; border-radius: 20px !important ; padding: 10px; background-color: #7EC585; color: white;border: hidden">
                    VISIT
                </button>
            </div> 
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-4">
                    <img style="height: 80px; align-items: center; padding-left:50px; padding-bottom: 10px" src="https://cdn.haitrieu.com/wp-content/uploads/2021/10/Logo-Dai-hoc-FPT.png"/>
                </div>
                <div class="col-5" style="position: absolute; padding-left: 300px; font-size: 20px">
                    Lô E2a-7, Đường D1, Khu Công nghệ cao, P.Long Thạnh Mỹ, Tp. Thủ Đức, TP.HCM<br>
                    <span style="font-size: 15px">daihoc.hcm@fpt.edu.vn</br></span>
                    <span style="font-size: 15px">(028) 7300 5588</br></span>

                </div> 
                <div class="col-8" style="position: absolute; padding-left: 900px; font-size: 15px; display: flex;">
                    <div>
                        About
                        Growers
                        Merchants
                        Partner
                        Contact
                    </div>
                    <div style="padding-left: 100px">
                      Facebook
                      Twitter
                      Linkedin
                      Instagram
                    </div>
                </div>
            </div>
        </div>
    </footer>
</html>
