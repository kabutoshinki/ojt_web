<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/CSS/manage.css">
    <link rel="stylesheet" href="/CSS/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/dda2b72c9e.js" crossorigin="anonymous"></script>
        
    <style>
        .students{
            background-image: url('/img/student.png');
            background-size: cover;
        }
         

        .manageCompany{
            background-image: url('/img/manageCompany.png');
            background-size: cover;
        }

        

        .request{
            background-image: url('/img/request.jpg');
            background-size: cover;
        }

        
        .companyTour{
            background-image: url('/img/companyTour.png');
            background-size: cover;
        }
 

        .companyRequest{
            background-image: url('/img/companyRequest.png');
            background-size: cover;
        }

        a{
            text-align: center;
            text-decoration: none;
            color: black;
        }

        a:hover {
            text-decoration: none;
        }


    </style>
</head>

<body>
    <jsp:include page="header.jsp"/>
        <hr>
         
    </div>
    
    <!-- Content -->

    <div class="container mt-3">

    <div class="row">
        <div class="col">
            <a href="/employee/students" class="text-decoration-none">
                <div class="d-flex justify-content-center mb-3 product container mt-3">
                    <div class="card students" style="width:300px;height: 300px;">
                        <div class="card-body">
                            <h4 class="card-title align-items-center">Students</h4>
                        </div>
                    </div>
                    <br>
                </div>
            </a>
        </div>
        <div class="col">
            <a class="text-decoration-none" href="/employee/companies">
                <div class="d-flex justify-content-center mb-3 product container mt-3">
                    <div class="card manageCompany" style="width:300px;height: 300px;">
                        <div class="card-body">
                            <h4 class="card-title">Companies Management</h4>
                        </div>
                    </div>
                    <br>
                </div>
            </a>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <a class="text-decoration-none" href="/employee/candidatesList">
                <div class="d-flex justify-content-center mb-3 product container mt-3">
                    <div class="card request" style="width:300px;height: 300px;">
                        <div class="card-body">
                            <h4 class="card-title">Student Request</h4>
                        </div>
                    </div>
                    <br>
                </div>
            </a>
        </div>
         <div class="col-md-6">
            <a href="status.html">
                <div class="d-flex justify-content-center mb-3 product container mt-3">
                    <div class="card companyRequest" style="width:300px;height: 300px;">
                        <div class="card-body">
                            <h4 class="card-title">Company Request</h4>
                        </div>
                    </div>
                    <br>
                </div>
            </a>
        </div>
    </div>

</div>

<hr>
<!-- footer -->
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
 

</body>

</html>