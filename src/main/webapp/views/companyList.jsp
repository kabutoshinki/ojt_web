<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Company List</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CSS/companyList.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/dda2b72c9e.js" crossorigin="anonymous"></script>
    </head>

    <body>
        
        <div class="wrap">
            <div class="header d-flex p-3">
                <div class="d-flex flex-grow-1 p-1 info">
                    <div class='p-2'>
                        <i class="fa-solid fa-envelope"></i> <span>daihoc.hcm@fpt.edu.vn</span>
                    </div>
                    <div class='p-2'>
                        <i class="fa-solid fa-phone"></i> <span>(028)73005588</span> 
                    </div>
                </div>
                <div class="d-flex align-items-center justify-content-around p-1">
                    <div class="text-light">
                        <a href=""><i class="fa-solid fa-user-large"></i> Login</a>
                    </div>
                </div>
            </div>  
            <div class="container ">
                <div class="row">
                    <div class="col-sm-5">
                        <img src="/img/fu.jpg" width="280"/>
                    </div>
                    <div class="col-sm-7 menu align-items-center">
                        <div class="">
                            <a href=""> Home </a>
                        </div>
                        <div class="">
                            <a href=""> OJT </a>
                        </div>
                        <div class="">
                            <a href=""> CNH </a>
                        </div>
                        <div class="">
                            <a href=""> Company Tour </a>
                        </div>
                        <div>
                            <form action="" method="post">
                                <input type="text" placeholder="Search here">
                                <button type="submit">
                                    <i class="bi bi-search"> Search</i>
                                </button>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
            <hr>
            <div class="container main-content">
                <div class="row" style="">
                    <form action="" method="post">
                        <input type="text" placeholder="Search here">
                        <button type="submit">
                            <i class="bi bi-search"> Search</i>
                        </button>
                    </form>
                </div>
                <br/>
                <div class="row" style="justify-content: center">

                    <c:forEach items="${jobList}" var= "o">

                        <div class="col-sm-3 list-comp">
                            <form style="text-align: center"  >
                                <img src="/img/fpt-software.png" width="300"><br/>
                                <hr>
                                <p style="display: none ;" name="idJob" >${o.idJob}</p>
                                <p style="text-align: center"/>${o.companyDetail.companyName}<br/>
                                <p style="text-align: center;"/>${o.slot} Job - Ho Chi Minh<br/><br/>
                                <a href="/jobController/jobDetail/${o.idJob}"><input type="button" value="Details"  style="background-color: #ccffcc; border-radius: 10px; padding: 4px 25px"/></a>
                                
                            </form>
                        </div>
                    </c:forEach>

                    <!-- <div class="col-sm-3 list-comp">
                        <form style="text-align: center">
                            <img src="/img/logofpt.png" width="300"><br/>
                            <hr>
                            <p style="text-align: center"/>LAZADA GROUP<br/>
                            <p style="text-align: center"/>7 Jobs - Ho Chi Minh<br/><br/>
                            <input type="button" value="Details" style="background-color: #ccffcc; border-radius: 10px; padding: 4px 25px"/>
                        </form>
                    </div>
                    <div class="col-sm-3 list-comp">
                        <form style="text-align: center">
                            <img src="/img/logofpt.png" width="300"><br/>
                            <hr>
                            <p style="text-align: center"/>TRAVALA.COM<br/>
                            <p style="text-align: center"/>3 Jobs - Ha Noi<br/><br/>
                            <input type="button" value="Details" style="background-color: #ccffcc; border-radius: 10px; padding: 4px 25px"/>
                        </form>
                    </div>
                </div>
                <br/>
                <div class="row" style="justify-content: center">
                    <div class="col-sm-3 list-comp">
                        <form style="text-align: center">
                            <img src="img/logofpt.png" width="300"><br/>
                            <hr>
                            <p style="text-align: center"/>FPT SOFTWARE<br/>
                            <p style="text-align: center"/>7 Jobs - Ho Chi Minh<br/><br/>
                            <input type="button" value="Details" style="background-color: #ccffcc; border-radius: 10px; padding: 4px 25px"/>
                        </form>
                    </div>

                    <div class="col-sm-3 list-comp">
                        <form style="text-align: center">
                            <img src="img/logofpt.png" width="300"><br/>
                            <hr>
                            <p style="text-align: center"/>PASCALIA ASIA VIETNAM<br/>
                            <p style="text-align: center"/>1 Jobs - Ho Chi Minh<br/><br/>
                            <input type="button" value="Details" style="background-color: #ccffcc; border-radius: 10px; padding: 4px 25px"/>
                        </form>
                    </div>
                    <div class="col-sm-3 list-comp">
                        <form style="text-align: center">
                            <img src="img/logofpt.png" width="300"><br/>
                            <hr>
                            <p style="text-align: center"/>GOLINE CORPORATION<br/>
                            <p style="text-align: center"/>3 Jobs - Ha Noi<br/><br/>
                            <input type="button" value="Details" style="background-color: #ccffcc; border-radius: 10px; padding: 4px 25px"/>
                        </form>
                    </div> -->
                </div>
                <br/>
                <div class="" style="text-align: center">
                    <a href=""><i class="bi bi-arrow-down-short"></i>Xem thêm</a>
                </div>

            </div>  
        </div>
        <footer>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-3 ft-logo">
                        <img src="/img/logofpt.png" width="200"/>
                    </div>
                    <diV class="col-3">
                        <h2 style="font-size: larger">Lô E2a-7, Đường D1, P. Long Thạnh Mỹ, 
                            Thành Phố Thủ Đức, Thành phố Hồ Chí Minh
                        </h2>
                        <p>
                            contact@lift.agencyr.com<br/>
                            (028) 7300 5588
                        </p>
                    </diV>
                    <div class="col-2">
                        <ul>
                            <li>About</li>
                            <li>Growers</li>
                            <li>Merchants</li>
                            <li>Partners</li>
                            <li>Contact</li>
                        </ul>
                    </div>
                    <div class="col-2">
                        <ul>
                            <li>Facebook</li>
                            <li>Twitter</li>
                            <li>Linkedin</li>
                            <li>Instagram</li>
                        </ul>
                    </div>
                    <div class="col-2 arrow-up">
                        <i class="bi bi-arrow-up-circle-fill"></i>
                    </div>
                </div>
            </div>
        </footer>
        <hr>
        <div class="space">

        </div>
    </body>
</html>
