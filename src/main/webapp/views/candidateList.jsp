<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>

        <html>

        <head>
            <title>TODO supply a title</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
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
            <link rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
            <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css">

        </head>

        <body>
            <jsp:include page="header.jsp" />
            <%@include file="sliderbar.jsp" %>
            <br />
            <div class="container">

                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb align-items-center">
                        <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
                        <li class="breadcrumb-item"><a href="/employee" style="padding:0;display: inline;">Employee</a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">Candidate</li>
                    </ol>
                </nav>

                <br />
                <!-- content -->
                <header class="container">

                    <div class="form-group row align-items-center">
                        <label for="inputDateVisit" class="col-md-4 col-form-label title">
                            <h1>List Of Candidates</h1>
                        </label>
                    </div>

                    <div class="form-group row align-items-center mb-3 mr-3">
                        <a class="btn btn-lg btn-outline-success mr-3" href="#"><i class="bi bi-plus-circle"></i>
                            Create</a>
                        <a class="btn btn-lg btn-outline-primary" href="#"><i class="bi bi-arrow-clockwise"></i>
                            Reload</a>
                    </div>

                </header>


                <hr>

                <div class="table-responsive-lg">
                <table id="myTable" class="table table-striped container">
                    <thead>
                        <tr>
                            <th class="text-center">No</th>
                            <th class="text-center">Student ID</th>
                            <th class="text-center">Student Name</th>
                            <th class="text-center">Major</th>
                            <th class="text-center">Detail Information</th>
                            <th class="text-center">CV</th>
                            <th class="text-center">Company</th>
                            <th class="text-center">Status</th>
                            <th class="text-center">Operations</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${candidates}" var="o">
                            <tr>
                                <td>${o.id}</td>
                                <td>SE150011</td>
                                <td>${o.account.fullName}</td>
                                <td>Kỹ thuật phần mềm</td>
                                <td>
                                    <a href="" class="btn btn-outline-info btn-sm"><i class="bi bi-eye"></i> View Detail</a>
                                </td>
                                <td>
                                    <a href="" class="btn btn-outline-info btn-sm"><i class="bi bi-eye"></i> View CV</a>
                                </td>
                                <td>${o.job.company.name}</td>
                                <td>${o.status}</td>
                                <td>
                                    <!-- <c:if test="${account.role.equals('COMPANY')=='true'}">
                            <a href="/companyController/verify/${o.id}/1">
                                <button type="submit" class="btn btn-sm btn-outline-success"  name="op" value="update"><i class="bi bi-check-circle"></i> Accepted
                                </button>
                            </a>
                            <a href="/companyController/verify/${o.id}/2">
                                <button type="button" class="btn btn-sm btn-outline-danger" data-bs-dismiss="modal" name="op" value="cancel"><i class="bi bi-x-circle"></i> Denied</button>
                            </a>
                        </c:if> -->
                                    <a href="verify/${o.id}/1">
                                        <button type="submit" class="btn btn-sm btn-outline-success" name="op"
                                            value="update"><i class="bi bi-check-circle"></i> Accepted
                                        </button>
                                    </a>
                                    <a href="verify/${o.id}/2">
                                        <button type="button" class="btn btn-sm btn-outline-danger"
                                            data-bs-dismiss="modal" name="op" value="cancel"><i
                                                class="bi bi-x-circle"></i> Denied</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>


                </table>
                </div>
            </div>


            <hr>
            <!-- footer -->
            <footer>
                <jsp:include page="footer.jsp" />
            </footer>
            <script src=" https://code.jquery.com/jquery-3.5.1.js"></script>
            <script src=" https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
            <script src=" https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
            <script>
                 
                $(document).ready(function () {
                    $('#myTable').DataTable();
                });              
            </script>
        </body>

        </html>