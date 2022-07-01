<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <html>

        <head>
            <title>TODO supply a title</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
            <link rel="stylesheet" href="/CSS/manage.css">
            <link rel="stylesheet" href="/CSS/styles.css">
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
                .candidates {
                    background-image: url('/img/candidates.jpg');
                    background-size: cover;
                }

                .candidates:hover {
                    background-image: url('/img/candidates.gif');
                    background-size: cover;
                }

                .company {
                    background-image: url('/img/company.png');
                    background-size: cover;
                }

                .company:hover {
                    background-image: url('/img/company.gif');
                    background-size: cover;
                }


                .status {
                    background-image: url('/img/status.jpg');
                    background-size: cover;
                }

                .status:hover {
                    background-image: url('/img/status.gif');
                    background-size: cover;
                }

                a {
                    text-align: center;
                    text-decoration: none;
                    color: black;
                }

                a:hover {
                    text-decoration: none;
                }

                .card-body {
                    padding: 7rem 1rem;

                }
                .card-title{
                    font-weight: bold;

                }
            </style>
        </head>

        <body>


            <%@include file="header.jsp" %>
                <!-- Content -->

                <div class="container mt-3">

                    <div class="row">
                        <div class="col">
                            <a href="/company/candidatesList" class="text-decoration-none">
                                <div class="d-flex justify-content-center mb-3 product container mt-3">
                                    <div class="card candidates" style="width:300px;height: 300px;">
                                        <div class="card-body">
                                            <h4 class="card-title">Candidates Management</h4>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </a>
                        </div>
                        <div class="col">
                            <a class="text-decoration-none" href="/company/insertPage">
                                <div class="d-flex justify-content-center mb-3 product container mt-3">
                                    <div class="card company" style="width:300px;height: 300px;">
                                        <div class="card-body">
                                            <h4 class="card-title">Post Intership Requirement</h4>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </a>
                        </div>
                        <div class="col">
                            <a href="/company/internshipRequirement">
                                <div class="d-flex justify-content-center mb-3 product container mt-3">
                                    <div class="card status" style="width:300px;height: 300px;">
                                        <div class="card-body">
                                            <h4 class="card-title">View Internship Requirement</h4>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </a>
                        </div>
                        <div class="col">
                            <a href="status.html">
                                <div class="d-flex justify-content-center mb-3 product container mt-3">
                                    <div class="card status" style="width:300px;height: 300px;">
                                        <div class="card-body">
                                            <h4 class="card-title">Evaluation Intern</h4>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </a>
                        </div>
                        <div class="col">
                            <a href="/company/internsList">
                                <div class="d-flex justify-content-center mb-3 product container mt-3">
                                    <div class="card status" style="width:300px;height: 300px;">
                                        <div class="card-body">
                                            <h4 class="card-title">Intern Management</h4>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </a>
                        </div>
                    </div>

                </div>
                <footer>
                    <%@include file="footer.jsp" %>
                </footer>




        </body>

        </html>