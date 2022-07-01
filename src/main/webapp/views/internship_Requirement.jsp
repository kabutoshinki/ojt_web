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


        </head>

        <body>
            <jsp:include page="header.jsp" />

            <!-- content -->
            <header class="container">

                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb align-items-center">
                        <li class="breadcrumb-item"><a href="/company/managePage" style="padding:0">Company</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Internship_Requirement</li>
                    </ol>
                </nav>

                <div class="form-group row align-items-center">
                    <label for="inputDateVisit" class="col col-form-label title">
                        <h1 style="color: orange;">Internship Requirement</h1>
                    </label>
                </div>
            </header>
            <hr>
            <div class="container">
                <p>Type something in the input field to search the table</p>
                <input class="form-control" id="myInput" type="text" placeholder="Search..">
                <br>
                <div class="table-responsive">

                    <table class="table table-striped text-center">
                        <thead class="text-center">
                            <tr>
                                <th>No</th>
                                <th>Apply Position</th>
                                <th>Internship Description</th>
                                <th>Requirement</th>
                                <th>Slot</th>
                                <th>Status</th>
                                <th>Reason</th>
                                <th>Operations</th>
                            </tr>
                        </thead>
                        <tbody id="myTable">
                            <c:forEach items="${candidates}" var="o">
                                <tr>
                                    <td>${o.id}</td>
                                    <td>SE150011</td>
                                    <td>${o.account.fullName}</td>
                                    <td>Kỹ thuật phần mềm</td>
                                    <td>
                                        <a href="#">click here</a>
                                    </td>
                                    <td>
                                        <a href="#">CV</a>
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
                                        <a href="verify/${o.id}/1"
                                            class="btn btn-sm btn-outline-success mt-auto mb-auto" name="op"
                                            value="accept">
                                            <i class="bi bi-check-circle"></i> Accepted
                                        </a>
                                        <a href="verify/${o.id}/2" class="btn btn-sm btn-outline-danger mt-auto mb-auto"
                                            name="op" value="remove">
                                            <i class="bi bi-x-circle"></i> Denied
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            <!-- Example -->
                            <tr>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>
                                    <a href="verify/${o.id}/1" class="btn btn-sm btn-outline-success mt-auto mb-auto"
                                        name="op" value="accept">
                                        <i class="bi bi-check-circle"></i> Accept
                                    </a>
                                    <a href="verify/${o.id}/2" class="btn btn-sm btn-outline-danger mt-auto mb-auto"
                                        name="op" value="remove">
                                        <i class="bi bi-x-circle"></i> Deny
                                    </a>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                </div>
            </div>



            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>

            <hr>
            <!-- footer -->
            <footer>
                <jsp:include page="footer.jsp" />
            </footer>

            <script>
                $(document).ready(function () {
                    $("#myInput").on("keyup", function () {
                        var value = $(this).val().toLowerCase();
                        $("#myTable tr").filter(function () {
                            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                        });
                    });
                });
            </script>
        </body>

        </html>