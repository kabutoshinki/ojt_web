<%-- Document : listofstudent Created on : Jun 18, 2022, 8:20:20 PM Author : admin --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>Verify student application</title>
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
<%
    session.setAttribute("successMessage", null);
    session.setAttribute("dangerMessage", null);
    session.setAttribute("warningMessage", null);
%>

<%@include file="sliderbar.jsp" %>
<br/>

<div class="container">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb align-items-center">
            <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
            <li class="breadcrumb-item"><a href="/employee"
                                           style="padding:0;display: inline;">Employee</a></li>
            <li class="breadcrumb-item active" aria-current="page">External Applications</li>
        </ol>
    </nav>

    <br/>
    <div class="container" style="justify-content: center;">
        <div>
            <div class="row">
                <div class="col">
                    <h1 style="color: orange">List of External Applications</h1>
                </div>
            </div>

            <br/>
            <div class="container">
                <div class="table-responsive-lg">
                    <table id="myTable" class="table table-bordered">
                        <thead>
                        <tr>
                            <th>No.</th>
                            <th>Student ID</th>
                            <th>Student Name</th>
                            <th>Company Name</th>
                            <th>Company Email</th>
                            <th>Company Phone</th>
                            <th>Resources</th>
                            <th>Evaluation Detail</th>
                            <th>Semester</th>
                            <th>Status</th>
                            <th>Verifier</th>
                            <th>Operation</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${applyList}" var="o" varStatus="loop">
                            <tr>
                                <td>${loop.count}</td>
                                <td class="text-truncate" style="max-width: 150px;"
                                    title="${o.student.studentId}">${o.student.studentId}</td>
                                <td class="text-truncate" style="max-width: 150px;"
                                    title="${o.student.account.fullName}">${o.student.account.fullName}</td>
                                <td class="text-truncate" style="max-width: 150px;"
                                    title="${o.companyName}">${o.companyName}</td>
                                <td><a
                                        href="mailto: ${o.companyEmail}" class="text-truncate" style="max-width: 150px;"
                                        title="${o.companyEmail}">${o.companyEmail}</a>
                                </td>
                                <td class="text-truncate" style="max-width: 150px;"
                                    title="${o.companyPhone}">${o.companyPhone}</td>
                                <td title="Resources">
                                    <a href="${o.contractPath}" class="btn btn-outline-info btn-sm">Contract</a>
                                    <a href="${o.letterPath}" class="btn btn-outline-info btn-sm">Letter</a>
                                </td>
                                <td>
                                    <c:if test="${o.application.status.equals('Passed') ||
                                                    o.application.status.equals('Completed') ||
                                                    o.application.status.equals('Not Passed') ||
                                                    o.application.status.equals('Interning')}">
                                        <a href="/employee/evaluate/${o.application.id}"
                                           class="btn btn-outline-info btn-sm"><i
                                                class="bi bi-eye"></i> View Detail</a>
                                    </c:if>
                                </td>
                                <td class="text-truncate" style="max-width: 50px;"
                                    title="${o.application.semester.semester}">${o.application.semester.semester}</td>

                                <td>${o.application.status}</td>
                                <td class="text-truncate" style="max-width: 150px;"
                                    title="${o.employee.account.fullName}">${o.employee.account.fullName}</td>
                                <td>
                                    <a style="${o.application.status=='Waiting' || o.application.status=='Denied'?'':'pointer-events: none; background-color: lightgrey'}"
                                       href="verifyExternalApplication/${o.id}/Accepted"
                                       class="btn btn-sm btn-outline-success mt-auto mb-auto" name="op"
                                       value="accept">
                                        <i class="bi bi-check-circle"></i> Accept
                                    </a>
                                    <a style="${o.application.status=='Processing' || o.application.status=='Waiting'?'':'pointer-events: none; background-color: lightgrey'}"
                                       href="verifyExternalApplication/${o.id}/Denied"
                                       class="btn btn-sm btn-outline-danger mt-auto mb-auto"
                                       name="op" value="remove">
                                        <i class="bi bi-x-circle"></i> Deny
                                    </a>
                                </td>
                            </tr>
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
</script>
</body>

</html>