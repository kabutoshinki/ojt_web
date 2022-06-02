<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>TODO supply a title</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
            <link rel="stylesheet" href="/CSS/style.css">
            <link rel="stylesheet" href="/CSS/form.css">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
                integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                crossorigin="anonymous">
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                crossorigin="anonymous"></script>
            <script src="https://kit.fontawesome.com/dda2b72c9e.js" crossorigin="anonymous"></script>
            <style>
                option {
                    overflow: auto;
                }
            </style>

        </head>

        <body>
            <div class="wrap">
                <div class="container-fluid header d-flex p-3 align-items-center">
                    <div class="col  d-flex flex-grow-1 p-1 info">
                        <div class='p-2'>
                            <i class="fa-solid fa-envelope"></i> <span>daihoc.hcm@fpt.edu.vn</span>
                        </div>
                        <div class='p-2'>
                            <i class="fa-solid fa-phone"></i> <span>(028)73005588</span>
                        </div>
                    </div>
                    <div class="col ">
                        <a href="manage.html" class="btn btn-light">Company</a>
                    </div>
                    <div class="col  d-flex align-items-center justify-content-around p-1">
                        <div class="text-light">
                            <a href="/oauth2/authorization/google" class="btn btn-light"><i class="bi bi-google"></i>
                                Login</a>
                        </div>
                    </div>
                </div>


                <nav class="navbar navbar-expand-md">
                    <div class="container">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
                            <i class="btn btn-secondary bi bi-list"></i>
                        </button>
                        <a class="navbar-brand mr-auto" href="#"><img src="/img/fu.jpg" width="300" /></a>
                        <div class="collapse navbar-collapse" id="Navbar">
                            <ul class="navbar-nav menu mr-auto ml-auto">
                                <li class="nav-item active mr-5"><a class="nav-link" href="index.html">Home</a></li>
                                <li class="nav-item mr-5"><a class="nav-link" href="#">OJT</a></li>
                                <li class="nav-item mr-5"><a class="nav-link" href="#">CNH</a></li>
                                <li class="nav-item mr-5"><a class="nav-link" href="#">Company Tour</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>



                <hr>

            </div>

            <!-- content -->
            <form class="mt-5" action="/insertJob" method="post" ModelAttribute="Job">
                <div class="container rounded mt-5 mb-5">
                    <div class="row form">
                        <div class="col-md-4 border-right">
                            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                <img class="rounded-circle mt-5 mb-3" src="/img/logocompany.png">
                                <span>Company Name: Fsoft</span>
                                <span class="text-black-50">Phone: 02873005588</span>
                                <span>Mail: daihoc.hcm@fpt.edu.vn</span>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <div class="p-3 py-5">
                                <div class="d-flex justify-content-between align-items-center mb-3 text-center">
                                    <h1>Đăng ký Doanh Nghiệp</h1>
                                </div>

                                <!-- <div class="form-group row">
                                    <label for="inputJob" class="col-sm-3 col-form-label">Apply Job</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" name="applyJob" placeholder="">
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div> -->

                                <div class="form-group row">
                                    <label for="inputDescription" class="col-sm-3 col-form-label">Job
                                        Description</label>
                                    <div class="col-sm-6">
                                        <textarea class="form-control" name="description" id="description"
                                            rows="3"></textarea>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>

                                <div class="form-group row">
                                    <label for="inputSkill" class="col-sm-3 col-form-label">Job Requirements</label>
                                    <div class="col-sm-6">
                                        <textarea class="form-control" name="requirement" id="skill"
                                            rows="3"></textarea>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputMajor" class="col-sm-3 col-form-label">Major</label>
                                    <div class="col-sm-6">
                                        <select class="form-control text-center" aria-label="Default select example">
                                        
                                            <c:forEach items="${majorList}" var= "o">
                                                <p>${o.major}</p>
                                                <option value="${o.id}">${o.major}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>

                                <div class="form-group row">
                                    <label for="inputSlot" class="col-sm-3 col-form-label">Slot</label>
                                    <div class="col-sm-6">
                                        <input type="number" class="form-control" name="slot" placeholder="" value="1"
                                            min="1">
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>

                                <div class="form-group row">
                                    <label for="inputVisit" class="col-sm-3 col-form-label">Form Visit</label>
                                    <div class="col-sm-7">
                                        <a class="btn btn-primary" href="formVisit.html">Create From</a>
                                    </div>
                                    <div class="col-sm-2"></div>
                                </div>
                                <div class="mt-5 text-center">
                                    <input type="submit" name="submit" class="btn btn-primary">
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </form>
            <hr>



            <!-- footer -->
            <footer>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-3 ft-logo">
                            <img src="/img/logofpt.png" width="200" />
                        </div>
                        <diV class="col-3">
                            <h2 style="font-size: larger">Lô E2a-7, Đường D1, phường Long Thạnh Mỹ,
                                Thành Phố Thủ Đức, Thành phố Hồ Chí Minh
                            </h2>
                            <p>
                                contact@lift.agencyr.com<br />
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