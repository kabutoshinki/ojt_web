<%-- Document : applylist Created on : Jun 13, 2022, 7:38:20 PM Author : admin --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Apply list</title>
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


<br/>
<div class="container">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb align-items-center">
            <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">My Applications</li>
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
        session.setAttribute("dangerMessage", null);
        session.setAttribute("warningMessage", null); %>

</div>
<br/>
<div class="container">
    <div class="row">
        <div class="col-sm-5">
            <h1 style="color: orange">My Application</h1>
        </div>
    </div>

    <div class="table-responsive-lg">
        <table id="myTable" class="table table-bordered text-center">
            <thead>
            <tr style="text-align: center">
                <th class="text-center">No.</th>
                <th class="text-center">Position</th>
                <th class="text-center">Details</th>
                <th class="text-center">CV</th>
                <th class="text-center">Verifier</th>
                <th class="text-center">Status</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="o" items="${applyList}" varStatus="loop">
                <tr style="text-align: center">
                    <td>${loop.count}</td>
                    <td class="text-truncate" style="max-width: 150px;"
                        title="${o.job.position.position}">${o.job.position.position}</td>
                    <!-- <td><a href="/view/recruitment/${o.job.id}" class="btn btn-outline-info btn-sm"><i
                            class="bi bi-eye"></i> View</a></td> -->
                    <td>
                        <button class="btn btn-outline-info btn-sm" data-toggle="modal"
                                data-target="#viewModal_${o.id}">
                            <i class="bi bi-eye"></i> View
                        </button>
                    </td>
                    <td title="${o.cv.name}"><a href="${o.cv.path}"
                                                class="btn btn-outline-info btn-sm">View CV</a></td>
                    <td class="text-truncate" style="max-width: 150px;"
                        title="${o.employee.account.fullName}">
                            ${o.employee.account.fullName}</td>
                    <td>${o.status}</td>

                    <td>
                        <input type="text" name="redirect" value="applications" hidden>
                        <a style="${o.status=='Passed Interview' && o.student.applicationStatus == false?'':'pointer-events: none; background-color: lightgrey'}"
                           href="verifyIntern/${o.id}/Interning/applications"
                           class="btn btn-sm btn-outline-success mt-auto mb-auto" name="op"
                           value="accept">
                            <i class="bi bi-check-circle"></i> Intern
                        </a>

                        <a style="${o.status=='Passed Interview' && o.student.applicationStatus == false?'':'pointer-events: none; background-color: lightgrey'}"
                           href="verifyIntern/${o.id}/Refused/applications"
                           class="btn btn-sm btn-outline-danger mt-auto mb-auto" name="op"
                           value="remove">
                            <i class="bi bi-x-circle"></i> Refuse
                        </a>
                    </td>
                </tr>
                <!-- View Modal -->

                <div class="modal fade" id="viewModal_${o.id}" tabindex="-1"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">

                        <div class="modal-content text-center">
                            <div class="modal-header"
                                 style="background: orange; text-align: center; display: unset;">
                                <h5 class="modal-title" id="exampleModalLabel">
                                        ${o.job.company.account.fullName}
                                </h5>
                            </div>
                            <div class="modal-body text-center">

                                <div class="mb-3">
                                    <img src="/img/default.png" alt="avatar image"
                                         class="img-fluid" style="height: 150px;" disabled>
                                </div>

                                <div class="input-group mb-3">
                                                            <span class="input-group-text"
                                                                  id="basic-addon1">Semester</span>
                                    <input class="form-control" id="semester" name="semester"
                                           value="${o.semester.semester}" disabled></input>
                                </div>

                                <div class="input-group mb-3">
                                                            <span class="input-group-text"
                                                                  id="basic-addon1">Position</span>
                                    <input class="form-control" id="position" name="position"
                                           value="${o.job.position.position}" disabled></input>
                                </div>

                                <div class="input-group mb-3">
                                                            <span class="input-group-text"
                                                                  id="basic-addon1">Description</span>

                                    <textarea class="form-control" id="description"
                                              placeholder="Enter Description" name="description"
                                              value="" disabled></textarea>

                                </div>
                                <div class="input-group mb-3">
                                                            <span class="input-group-text"
                                                                  id="basic-addon1">Requirement</span>
                                    <textarea class="form-control" id="requirement"
                                              placeholder="Enter Requirement" name="requirement"
                                              value="" disabled></textarea>
                                </div>

                            </div>
                            <div class="modal-footer mr-auto ml-auto">
                                <button type="button" class="btn btn-outline-danger"
                                        data-dismiss="modal"><i class="bi bi-x-circle"></i>
                                    Close
                                </button>
                            </div>
                        </div>

                    </div>
                </div>

                <!-- ++++++++++++++++++++++++++++++++++++++++++++ -->
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<br/>

<jsp:include page="footer.jsp"/>

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