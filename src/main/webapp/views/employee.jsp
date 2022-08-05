<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>

<head>
    <title>Employee</title>
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
        a {
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

<c:if test="${successMessage != null}">
    <div class="container alert alert-success alert-dismissible fade show" role="alert">
            ${successMessage}
        <button type="button" class="close" data-dismiss="alert">&times;</button>
    </div>
</c:if>
<c:if test="${dangerMessage != null}">
    <div class="container alert alert-danger alert-dismissible fade show" role="alert">
            ${dangerMessage}
        <button type="button" class="close" data-dismiss="alert">&times;</button>
    </div>
</c:if>
<c:if test="${warningMessage != null}">
    <div class="container alert alert-warning alert-dismissible fade show" role="alert">
            ${warningMessage}
        <button type="button" class="close" data-dismiss="alert">&times;</button>
    </div>
</c:if>
<%
    session.setAttribute("successMessage", null);
    session.setAttribute("dangerMessage", null);
    session.setAttribute("warningMessage", null);
%>

<!-- Content -->

<div class="container mt-3">

    <div class="row">
        <div class="col-12 col-lg-4">
            <a href="/employee/students">
                <div class="card mr-auto ml-auto mt-2 mb-2" style="width: 18rem;">
                    <img class="card-img-top img-fluid" src="/img/students.png" style="  height: 150px;"
                         alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text"><strong>Students</strong></p>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-12 col-lg-4">
            <a href="/employee/companies">
                <div class="card mr-auto ml-auto mt-2 mb-2" style="width: 18rem;">
                    <img class="card-img-top img-fluid" src="/img/companyAccount.png"
                         style="  height: 150px;" alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text"><strong>Companies</strong></p>
                    </div>
                </div>
            </a>
        </div>

        <div class="col-12 col-lg-4">
            <a href="/employee/requirements">
                <div class="card mr-auto ml-auto mt-2 mb-2" style="width: 18rem;">
                    <img class="card-img-top img-fluid" src="/img/verify.jpg" style="  height: 150px;"
                         alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text"><strong>Internship Requirement</strong></p>
                    </div>
                </div>
            </a>
        </div>

        <div class="col-12 col-lg-4">
            <a href="/employee/applications">
                <div class="card mr-auto ml-auto mt-2 mb-2" style="width: 18rem;">
                    <img class="card-img-top img-fluid" src="/img/verifyStudent.png"
                         style="  height: 150px;" alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text"><strong>Student Application</strong></p>
                    </div>
                </div>
            </a>
        </div>

        <div class="col-12 col-lg-4">
            <a href="/employee/externalApplications">
                <div class="card mr-auto ml-auto mt-2 mb-2" style="width: 18rem;">
                    <img class="card-img-top img-fluid" src="/img/external.png"
                         style="  height: 150px;" alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text"><strong>Student External Application</strong></p>
                    </div>
                </div>
            </a>
        </div>

        <div class="col-12 col-lg-4">
            <a href="/employee/internships">
                <div class="card mr-auto ml-auto mt-2 mb-2" style="width: 18rem;">
                    <img class="card-img-top img-fluid" src="/img/result.png" style="  height: 150px;"
                         alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text"><strong>Internship Result</strong></p>
                    </div>
                </div>
            </a>
        </div>

        <div class="col-12 col-lg-4" ${account.role=="ADMIN"?"":"hidden"}>
            <a href="/employee/semester">
                <div class="card mr-auto ml-auto mt-2 mb-2" style="width: 18rem;">
                    <img class="card-img-top img-fluid" src="/img/semester.png" style="  height: 150px;"
                         alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text"><strong>Semester</strong></p>
                    </div>
                </div>
            </a>
        </div>

        <div class="col-12 col-lg-4" ${account.role=="ADMIN"?"":"hidden"}>
            <a href="/employee/employees">
                <div class="card mr-auto ml-auto mt-2 mb-2" style="width: 18rem;">
                    <img class="card-img-top img-fluid" src="/img/employee.png" style="  height: 150px;"
                         alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text"><strong>Employee</strong></p>
                    </div>
                </div>
            </a>
        </div>

    </div>

</div>


<!-- footer -->
<footer>
    <jsp:include page="footer.jsp"/>
</footer>


</body>

</html>