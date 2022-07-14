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
                <!-- content -->
                <div class="container">

                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb align-items-center">
                            <li class="breadcrumb-item"><a href="/company/managePage" style="padding:0">Company</a></li>
                            <li class="breadcrumb-item active" aria-current="page">List_Of_Interns</li>
                        </ol>
                    </nav>

                    <div class="form-group row align-items-center">
                        <label for="inputDateVisit" class="col-md-4 col-form-label title">
                            <h1 style="color: orange;">List Of Interns</h1>
                        </label>

                    </div>

                    <button class="btn btn-outline-primary" formaction="<c:url value=" /" />">
                    <i class="bi bi-upload"></i> Import Evaluation
                    </button>

                    <button class="btn btn-outline-info" formaction="<c:url value=" /" />">
                    <i class="bi bi-box-arrow-in-down"></i> Export
                    </button>



                    <hr>
                    <div class="container">
                        <div class="table-responsive">

                            <table id="myTable" class="table table-striped text-center">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>Student ID</th>
                                        <th>Student Name</th>
                                        <th>Semester</th>
                                        <th>Position</th>
                                        <th>Start time</th>
                                        <th>End time</th>
                                        <th>Evaluation Detail</th>
                                        <th>Grade</th>
                                        <th>Status</th>
                                        <%--<th>Verifier</th>--%>
                                            <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${processList}" var="o" varStatus="loop">
                                        <tr>
                                            <td>${loop.count}</td>
                                            <td>${o.student.studentId}</td>
                                            <td>${o.student.account.fullName}</td>
                                            <td>${o.application.semester.semester}</td>
                                            <td>${o.application.job.position.position}</td>
                                            <td>${o.startDate}</td>
                                            <td>${o.startDate}</td>
                                            <td>
                                                <a href="/company/evaluate/${o.id}" class="btn btn-outline-info btn-sm"><i class="bi bi-eye"></i> View
                                                    Detail</a>
                                            </td>
                                            <td>${o.grade}</td>
                                            <td>${o.status}</td>
                                            <td>
                                                <button type="button" class="btn btn-outline-primary btn-sm"
                                                        data-toggle="modal" data-target="#updateModel_${o.id}">
                                                    <i class="fa fa-refresh"></i> Update
                                                </button>
                                                <%--<button type="button" class="btn btn-outline-danger btn-sm" style="color: red"
                                                        data-toggle="modal" data-target="#removeModel_${o.id}">
                                                    <i class="fa fa-trash"></i> Remove
                                                </button>--%>

                                                <!-- ++++++++++++++++ Update Requirement +++++++++++++++++ -->
                                                <div class="modal fade" id="updateModel_${o.id}" tabindex="-1" aria-labelledby="exampleModalLabel"
                                                     aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <form action="/company/updateProcess/${o.id}" method="post">
                                                            <div class="modal-content text-center">
                                                                <div class="modal-header"
                                                                     style="background: orange; text-align: center; display: unset;">
                                                                    <h5 class="modal-title" id="exampleModalLabel2">Update Form</h5>
                                                                </div>
                                                                <div class="modal-body text-center">
                                                                    <div class="input-group mb-3">
                                                                        <span class="input-group-text" id="basic-addon1">Start date</span>
                                                                        <input type="date" class="form-control" id="startDate" value="${o.startDate}"
                                                                               placeholder="Enter Start Date" name="startDate" required>
                                                                    </div>
                                                                    <div class="input-group mb-3">
                                                                        <span class="input-group-text" id="basic-addon1">End date</span>
                                                                        <input type="date" class="form-control" id="endDate" value="${o.endDate}"
                                                                               placeholder="Enter End Date" name="endDate" required>
                                                                    </div>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="submit" class="btn btn-sm btn-outline-success"
                                                                            id="import"><i class="bi bi-check-circle"></i>Upload</button>
                                                                    <button type="button" class="btn btn-sm btn-outline-danger"
                                                                            data-dismiss="modal"><i class="bi bi-x-circle"></i>Cancel</button>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                <!-- ++++++++++++++++ End Update Requirement +++++++++++++++++ -->

                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
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