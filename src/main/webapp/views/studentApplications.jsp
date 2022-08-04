<%-- Document : applylist Created on : Jun 13, 2022, 7:38:20 PM Author : admin --%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <title>Applications</title>
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


                    <br />
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
                        <% session.setAttribute("successMessage", null); session.setAttribute("dangerMessage", null);
                            session.setAttribute("warningMessage", null); %>

                    </div>
                    <br />
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-5">
                                <h1 style="color: orange">My Application</h1>
                            </div>
                        </div>

                        <div class="table-responsive-lg">
                            <table id="myTable" class="table table-bordered">
                                <thead>
                                    <tr style="text-align: center">
                                        <th>No.</th>
                                        <th>Company</th>
                                        <th>Position</th>
                                        <th>Details</th>
                                        <th>CV</th>
                                        <%--<th class="text-center">Verifier</th>--%>
                                            <th>Status</th>
                                            <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="o" items="${applyList}" varStatus="loop">
                                        <tr <%--style="text-align: center"--%>>
                                            <td>${loop.count}</td>
                                            <td class="text-truncate" style="max-width: 150px;"
                                                title="${o.job.company.account.fullName}">${o.job.company.account.fullName}</td>
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
                                                    class="btn btn-outline-info btn-sm" target="_blank">View CV</a></td>
                                            <td>${o.status}</td>

                                            <td>
                                                <input type="text" name="redirect" value="applications" hidden>
                                                <!-- <a style="${o.status=='Passed Interview' && o.student.applicationStatus == false?'':'pointer-events: none; background-color: lightgrey'}"
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
                        </a> -->

                                                <button
                                                    style="${o.status=='Passed Interview' && o.student.applicationStatus == false?'':'pointer-events: none; background-color: lightgrey'}"
                                                    class="btn btn-sm btn-outline-success mt-auto mb-auto" name="op"
                                                    value="accept" data-toggle="modal"
                                                    data-target="#acceptModal${o.id}">
                                                    <i class="bi bi-check-circle"></i> Intern
                                                </button>
                                                <!-- denyModal${o.id} -->
                                                <button
                                                    style="${o.status=='Passed Interview' && o.student.applicationStatus == false?'':'pointer-events: none; background-color: lightgrey'}"
                                                    data-toggle="modal" data-target="#denyModal${o.id}"
                                                    class="btn btn-sm btn-outline-danger mt-auto mb-auto" name="op"
                                                    value="remove">
                                                    <i class="bi bi-x-circle"></i> Refuse
                                                </button>

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
                                                            <img src="${o.job.company.account.avatar==null?'/img/default.png':o.job.company.account.avatar}"
                                                                alt="avatar image" class="img-fluid"
                                                                style="height: 150px;" disabled>
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
                                                                value="${o.job.description}"
                                                                disabled>${o.job.description}</textarea>

                                                        </div>
                                                        <div class="input-group mb-3">
                                                            <span class="input-group-text"
                                                                id="basic-addon1">Requirement</span>
                                                            <textarea class="form-control" id="requirement"
                                                                placeholder="Enter Requirement" name="requirement"
                                                                value="${o.job.requirement}"
                                                                disabled>${o.job.requirement}</textarea>
                                                        </div>
                                                        <div class="input-group mb-3">
                                                            <span class="input-group-text"
                                                                id="basic-addon1">Benefit</span>
                                                            <textarea class="form-control" id="benefit"
                                                                placeholder="Enter Benefit" name="benefit"
                                                                value="${o.job.benefit}"
                                                                disabled>${o.job.benefit}</textarea>
                                                        </div>
                                                        <div class="form-row">
                                                            <div class="col-6 input-group mb-3">
                                                                <span class="input-group-text" id="basic-addon1">Start
                                                                    Date</i></span>
                                                                <input type="date" class="form-control p-2"
                                                                    name="startDate" value="${o.job.startDate}"
                                                                    disabled>
                                                            </div>
                                                            <div class="col-6 input-group mb-3">
                                                                <span class="input-group-text" id="basic-addon1">End
                                                                    Date</span>
                                                                <input type="date" class="form-control" name="endDate"
                                                                    value="${o.job.endDate}" disabled>
                                                            </div>
                                                        </div>

                                                        <div class="input-group mb-3">
                                                            <span class="input-group-text" id="basic-addon1">Slot</span>
                                                            <input type="number" class="form-control" id="slot"
                                                                name="slot" value="${o.job.slot}" disabled>
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

                                        <!-- +++++++++++++++++++++++++++++++++++++++++++ -->

                                        <!-- Accept Modal -->
                                        <div class="modal fade" id="acceptModal${o.id}" tabindex="-1"
                                            aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <form action="verifyIntern/${o.id}/Interning/applications">
                                                    <div class="modal-content text-center">
                                                        <div class="modal-header"
                                                            style="background: orange; text-align: center; display: unset;">
                                                            <h5 class="modal-title" id="exampleModalLabel4">
                                                                Accept Form</h5>
                                                        </div>
                                                        <h4>Are you sure to intern in ${o.job.company.account.fullName}
                                                        </h4>
                                                        <div class="modal-footer">
                                                            <button type="submit"
                                                                class="btn btn-outline-success btn-sm">
                                                                <i class="bi bi-check-circle"></i>
                                                                Intern
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
                                        <!-- ++++++++++++++++++++++++++++++++++++++++++++ -->

                                        <!-- Deny Modal -->
                                        <div class="modal fade" id="denyModal${o.id}" tabindex="-1"
                                            aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <form action="verifyIntern/${o.id}/Refused/applications">
                                                    <div class="modal-content text-center">
                                                        <div class="modal-header"
                                                            style="background: orange; text-align: center; display: unset;">
                                                            <h5 class="modal-title" id="exampleModalLabel4">
                                                                Deny Form</h5>
                                                        </div>
                                                        <h4>Are you sure you want to refuse this student</h4>
                                                        <div class="modal-footer">
                                                            <button type="submit" class="btn btn-outline-danger btn-sm">
                                                                <i class="bi bi-x-circle"></i>
                                                                Refuse
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
                                        <!-- +++++++++++++++++++++++++++++++++++++ -->
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <br />

                    <jsp:include page="footer.jsp" />

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