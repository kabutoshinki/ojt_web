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
<jsp:include page="header.jsp"/>
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
<!-- content -->
<div class="container">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb align-items-center">
            <li class="breadcrumb-item"><a href="/company" style="padding:0">Company</a></li>
            <li class="breadcrumb-item active" aria-current="page">Candidates</li>
        </ol>
    </nav>

    <div class="form-group row align-items-center">
        <label for="inputDateVisit" class="col-md-4 col-form-label title">
            <h1 style="color: orange;">List Of Candidates</h1>
        </label>

    </div>

    <button class="btn btn-outline-info" formaction="<c:url value=" /" />">
        <i class="bi bi-box-arrow-in-down"></i> Export
    </button>


    <hr>
    <div class="container">
        <div class="table-responsive-lg">

            <table id="myTable" class="table table-striped text-center">
                <thead>
                <tr>
                    <th class="text-center">No</th>
                    <th class="text-center">Student Name</th>
                    <th class="text-center">Email</th>
                    <th class="text-center">Phone</th>
                    <th class="text-center">Position</th>
                    <th class="text-center">Detail Information</th>
                    <th class="text-center">CV</th>
                    <th class="text-center">Status</th>
                    <th class="text-center">Operations</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${candidateList}" var="o" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td class="text-truncate" style="max-width: 150px;"
                            title="${o.student.account.fullName}">${o.student.account.fullName}</td>
                        <td><a
                                href="mailto: ${o.student.account.email}" class="text-truncate"
                                style="max-width: 150px;"
                                title="${o.student.account.email}">${o.student.account.email}</a>
                        </td>
                        <td>${o.student.account.phone}</td>
                        <td class="text-truncate" style="max-width: 150px;"
                            title="${o.job.position.position}">${o.job.position.position}</td>
                        <td>
                            <a href="/view/recruitment/${o.job.id}" class="btn btn-outline-info btn-sm"><i
                                    class="bi bi-eye"></i> View Detail</a>
                        </td>
                        <td>
                            <a href="" class="btn btn-outline-info btn-sm"><i class="bi bi-eye"></i>
                                    ${o.cv.name}</a>
                        </td>
                        <td>${o.status}</td>
                        <td>
                            <a style="${o.status!='Passed' && o.status!='Rejected'?'':'pointer-events: none; background-color: lightgrey'}"
                               href="verifyApplication/${o.id}/nextStep"
                               class="btn btn-sm btn-outline-success mt-auto mb-auto" name="op"
                               value="accept">
                                <i class="bi bi-check-circle"></i> Next Step
                            </a>
                            <a style="${o.status!='Rejected' && o.status!='Passed'?'':'pointer-events: none; background-color: lightgrey'}"
                               href="verifyApplication/${o.id}/Rejected"
                               class="btn btn-sm btn-outline-danger mt-auto mb-auto" name="op"
                               value="remove">
                                <i class="bi bi-x-circle"></i> Reject
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
<hr>
<!-- footer -->
<footer>
    <jsp:include page="footer.jsp"/>
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