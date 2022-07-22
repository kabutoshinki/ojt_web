<%-- Document : listofstudent Created on : Jun 18, 2022, 8:20:20 PM Author : admin --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>List of student</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/CSS/styles.css">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
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
<%@include file="header.jsp" %>


<%@include file="sliderbar.jsp" %>
<br/>

<div class="container">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb align-items-center">
            <li class="breadcrumb-item"><a href="/employee"
                                           style="padding:0;display: inline;">Employee</a></li>
            <li class="breadcrumb-item active" aria-current="page">Students</li>
        </ol>
    </nav>
    <c:if test="${successMessage != null}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${successMessage}
            <button type="button" class="close" data-dismiss="alert">&times;</button>
        </div>
    </c:if>
    <c:if test="${dangerMessage != null}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${dangerMessage}
            <button type="button" class="close" data-dismiss="alert">&times;</button>
        </div>
    </c:if>
    <c:if test="${warningMessage != null}">
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                ${warningMessage}
            <button type="button" class="close" data-dismiss="alert">&times;</button>
        </div>
    </c:if>
    <% session.setAttribute("successMessage", null);
        session.setAttribute("dangerMessage",
                null);
        session.setAttribute("warningMessage", null); %>

    <br/>
    <div class="container" style="justify-content: center;">
        <div>
            <div class="row">
                <div class="col">
                    <h1 style="color: orange">List of Students</h1>
                </div>
            </div>
            <button type="button" class="btn btn-outline-primary" data-toggle="modal"
                    data-target="#mo">
                <i class="bi bi-box-arrow-in-down"> Import</i>
            </button>

            <div class="modal fade" id="filter" tabindex="-1"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <form action="/employee/students">
                        <div class="modal-content text-center">
                            <div class="modal-header"
                                 style="background: orange; text-align: center; display: unset;">
                                <h5 class="modal-title" id="exampleModalLabel4">
                                    Filter Form</h5>
                            </div>
                            <div class="modal-body text-center">
                                <div class="input-group mt-3 mb-3">
                                    <div class="input-group-prepend">
                                        <label class="input-group-text"
                                               for="inputGroupSelect01">Semester</label>
                                    </div>
                                    <select class="custom-select" id="inputGroupSelect01"
                                            name="semesterId">
                                        <option value="-1">Select...</option>
                                        <c:forEach var="o" items="${semesterList}">
                                            <option value="${o.id}" ${o.id==semesterId?"selected":""}>${o.semester}</option>
                                        </c:forEach>
                                    </select>

                                    <div class="input-group-prepend">
                                        <label class="input-group-text"
                                               for="inputGroupSelect01">Status</label>
                                    </div>
                                    <select class="custom-select" id="inputGroupSelect01"
                                            name="statusValue">
                                        <option value="all"}>Select...</option>
                                        <option value="Interning" ${statusValue.equals("Interning")=="true"?"selected":""}}>Interning</option>
                                        <option value="Passed" ${statusValue.equals("Passed")=="true"?"selected":""}}>Passed</option>
                                        <option value="Not Passed" ${statusValue.equals("Not Passed")=="true"?"selected":""}}>Not Passed</option>
                                    </select>
                                </div>
                            </div>

                            <div class="modal-footer">
                                <button type="submit"
                                        class="btn btn-outline-success btn-sm">
                                    <i class="bi bi-funnel"></i>
                                    Filter
                                </button>
                                <button type="button"
                                        class="btn btn-sm btn-outline-secondary"
                                        data-dismiss="modal">
                                    <i class="bi bi-x-circle"></i>
                                    Cancel
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="modal fade" id="mo" tabindex="-1"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <form action="/employee/uploadStudent" method="post"
                          enctype="multipart/form-data">
                        <div class="modal-content text-center">
                            <div class="modal-header"
                                 style="background: orange; text-align: center; display: unset;">
                                <h5 class="modal-title" id="exampleModalLabel">Import Form
                                </h5>
                            </div>
                            <div class="modal-body text-center">
                                <div class="form-group">
                                    <div class="custom-file mt-3">
                                        <label class="custom-file-label"
                                               for="customFile">Choose
                                            file</label>
                                        <input type="file" class="custom-file-input"
                                               name="file" id="fileImage" accept=".xlsx,.XLS">
                                        <input type="text" name="role" value="STUDENT"
                                               hidden>
                                        <input type="text" name="redirect" value="students"
                                               hidden>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-sm btn-outline-success"
                                        id="import"><i class="bi bi-check-circle"></i>
                                    Import
                                </button>
                                <button type="button" class="btn btn-sm btn-outline-danger"
                                        data-dismiss="modal"><i class="bi bi-x-circle"></i>
                                    Cancel
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <%--<a href="/employee/writeStudentFile" download>--%>
            <a href="/employee/writeStudentFile">
                <button class="btn btn-outline-info" formaction="<c:url value="
                                                    /" />"><i class="bi bi-box-arrow-in-down"></i> Export
                </button>
            </a>

            <button type="button" class="btn btn-outline-info" data-toggle="modal"
                    data-target="#filter" style="float: right;">
                <i class="bi bi-funnel-fill"></i> Filter
            </button>

            <a href="/template/Student.xlsx" download>
                <button class="btn btn-outline-info" formaction="<c:url value="
                                                    /" />"><i class="bi bi-box-arrow-in-down"></i> Download template
                </button>
            </a>

            <br/>
            <br/>
            <div class="container">
                <div class="table-responsive-lg">
                    <table id="myTable" class="table table-bordered">
                        <thead>
                        <tr>
                            <th>No.</th>
                            <th>Student ID</th>
                            <th>Student Name</th>
                            <th>Email</th>
                            <th>Details</th>
                            <th>Semester</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${studentList}" var="o" varStatus="loop">
                            <tr>
                                <td>${loop.count}</td>
                                <td>${o.studentId}</td>
                                <td class="text-truncate" style="max-width: 150px;"
                                    title="${o.account.fullName}">
                                        ${o.account.fullName}</td>
                                <td><a href="mailto: ${o.account.email}"
                                       class="text-truncate"
                                       style="max-width: 150px;"
                                       title="${o.account.email}">${o.account.email}</a>
                                </td>
                                <td>
                                    <button class="btn btn-outline-info btn-sm"
                                            data-toggle="modal"
                                            data-target="#inforModal_${o.id}"><i
                                            class="bi bi-eye"></i> View Detail
                                    </button>
                                </td>
                                <td class="text-truncate" style="max-width: 150px;"
                                    title="${o.semester.semester}">
                                        ${o.semester.semester}
                                </td>
                                <td>${o.account.status}</td>
                                <td>
                                    <button type="button"
                                            class="btn btn-outline-danger btn-sm"
                                            style="color: red" data-toggle="modal"
                                            data-target="#modelRemove_${o.id}">
                                        <i class="bi bi-trash-fill"></i> Remove
                                    </button>
                                </td>

                            </tr>
                            <!-- ++++++++++++++++ Remove Student +++++++++++++++++ -->
                            <div class="modal fade" id="modelRemove_${o.id}"
                                 tabindex="-1" aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <form action="/employee/removeStudent/${o.id}"
                                          method="post">
                                        <div class="modal-content text-center">
                                            <div class="modal-header"
                                                 style="background: orange; text-align: center; display: unset;">
                                                <h5 class="modal-title"
                                                    id="exampleModalLabel4">
                                                    Remove Form</h5>
                                            </div>
                                            <h1>Are you sure you want to remove
                                                    ${o.account.fullName}? This action
                                                cannot be undone.</h1>
                                            <div class="modal-footer">
                                                <button type="submit"
                                                        class="btn btn-outline-danger btn-sm"
                                                        style="color: red">
                                                    <i class="bi bi-trash-fill"></i>
                                                    Remove
                                                </button>
                                                <button type="button"
                                                        class="btn btn-sm btn-outline-secondary"
                                                        data-dismiss="modal">
                                                    <i class="bi bi-x-circle"></i>
                                                    Cancel
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

                            <!-- User information -->
                            <div class="modal fade" id="inforModal_${o.id}"
                                 tabindex="-1" aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content text-center">
                                        <div class="modal-header"
                                             style="background: orange; text-align: center; display: unset;">
                                            <h5 class="modal-title"
                                                id="exampleModalLabel">User
                                                Profile
                                            </h5>
                                        </div>
                                        <div class="modal-body text-center">
                                            <div class="mb-3">
                                                <img src="${o.account.avatar==null?'/img/default.png':o.account.avatar}"
                                                     alt="avatar image"
                                                     class="img-fluid"
                                                     style="height: 150px;" disabled>
                                            </div>

                                            <div class="input-group mb-3">
                                                                                    <span class="input-group-text"
                                                                                          id="basic-addon1"><i
                                                                                            class='fas fa-user-graduate'></i></span>
                                                <input type="text"
                                                       class="form-control"
                                                       id="studentName"
                                                       name="studentName"
                                                       value="${o.account.fullName}"
                                                       disabled>
                                            </div>

                                            <div class="input-group mb-3">
                                                                                    <span class="input-group-text"
                                                                                          id="basic-addon1"><i
                                                                                            class="bi bi-envelope-fill"></i></span>
                                                <input type="email"
                                                       class="form-control"
                                                       id="studentEmail"
                                                       name="studentEmail"
                                                       value="${o.account.email}"
                                                       disabled>
                                            </div>

                                            <div class="input-group mb-3">
                                                                                    <span class="input-group-text"
                                                                                          id="basic-addon1"><i
                                                                                            class="bi bi-telephone-fill"></i></span>
                                                <input type="tel"
                                                       class="form-control"
                                                       id="studentPhone"
                                                       name="studentPhone"
                                                       value="${o.account.phone}"
                                                       disabled>
                                            </div>


                                            <div class="input-group mb-3">
                                                                                    <span class="input-group-text"
                                                                                          id="basic-addon1"><i
                                                                                            class="bi bi-geo-alt-fill"></i></span>
                                                <textarea class="form-control"
                                                          id="studentAddress"
                                                          name="studentAddress"
                                                          value="${o.account.address}"
                                                          disabled>${o.account.address}</textarea>
                                            </div>

                                        </div>

                                        <div class="modal-footer mr-auto ml-auto">
                                            <button type="button"
                                                    class="btn btn-outline-danger"
                                                    data-dismiss="modal"><i
                                                    class="bi bi-x-circle"></i>
                                                Close
                                            </button>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <!-- +++++++++++++++++++++++++++++++++++++++++++++++++ -->
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>
    <br/>
</div>
</div>
<jsp:include page="footer.jsp"/>
<!-- ++++++++++++++++ -->
<script src=" https://code.jquery.com/jquery-3.5.1.js"></script>
<script src=" https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src=" https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
<script>


    $(document).ready(function () {
        $('#myTable').DataTable();
    });

    $(document).ready(function () {
        $("#import").click(function () {
            $("#success").modal();
        });
    });
    $(".custom-file-input").on("change", function () {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });
</script>
</body>

</html>