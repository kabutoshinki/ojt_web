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

                    <br />
                    <div class="container">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb align-items-center">
                                <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">My External Applications</li>
                            </ol>
                        </nav>

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
                                    <tr>
                                        <th>No.</th>
                                        <th>Company Name</th>
                                        <th>Information</th>
                                        <th>Evaluation</th>
                                        <th>Status</th>
                                        <%--<th>Verifier</th>--%>
                                            <th>Operation</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="o" items="${requestList}" varStatus="loop">
                                        <tr style="text-align: center">
                                            <td>${loop.count}</td>
                                            <td class="text-truncate" style="max-width: 150px;"
                                                title="${o.key.companyName}">${o.key.companyName}</td>
                                            <td>
                                                <button class="btn btn-outline-info btn-sm" data-toggle="modal"
                                                    data-target="#companyModal_${o.key.id}">
                                                    <i class="bi bi-eye"></i> View
                                                </button>
                                            </td>
                                            <td>
                                                <c:if test="${o.key.application.status.equals('Passed') ||
                                                    o.key.application.status.equals('Completed') ||
                                                    o.key.application.status.equals('Not Passed') ||
                                                    o.key.application.status.equals('Interning')}">
                                                    <button class="btn btn-outline-info btn-sm" data-toggle="modal"
                                                        data-target="#evaluateModal_${o.key.id}">
                                                        <i class="bi bi-eye"></i> View
                                                    </button>
                                                </c:if>
                                            </td>
                                            <td>${o.key.application.status}</td>
                                            <%--<td class="text-truncate" style="max-width: 150px;"
                                                title="${o.key.employee.account.fullName}">
                                                ${o.key.employee.account.fullName}
                                                </td>--%>
                                                <td>
                                                    <a style="${o.key.application.status=='Accepted' && o.key.student.applicationStatus == false?'':'pointer-events: none; background-color: lightgrey'}"
                                                        href="verifyIntern/${o.key.application.id}/Interning/externalApplications"
                                                        class="btn btn-sm btn-outline-success mt-auto mb-auto" name="op"
                                                        value="accept">
                                                        <i class="bi bi-check-circle"></i> Intern
                                                    </a>

                                                    <a style="${o.key.application.status=='Accepted' && o.key.student.applicationStatus == false?'':'pointer-events: none; background-color: lightgrey'}"
                                                        href="verifyIntern/${o.key.application.id}/Refused/externalApplications"
                                                        class="btn btn-sm btn-outline-danger mt-auto mb-auto" name="op"
                                                        value="remove">
                                                        <i class="bi bi-x-circle"></i> Refuse
                                                    </a>
                                                </td>
                                        </tr>


                                        <!-- Company Modal -->
                                        <div class="modal fade" id="companyModal_${o.key.id}" tabindex="-1"
                                            aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">

                                                <div class="modal-content text-center">
                                                    <div class="modal-header"
                                                        style="background: orange; text-align: center; display: unset;">
                                                        <h5 class="modal-title" id="exampleModalLabel">
                                                            ${o.key.companyName}
                                                        </h5>
                                                    </div>
                                                    <div class="modal-body text-center">

                                                        <div class="input-group mb-3">
                                                            <span class="input-group-text" id="basic-addon1"><i
                                                                    class="fas fa-calendar-alt"></i></span>
                                                            <input type="text" class="form-control" id="semester"
                                                                name="semester"
                                                                value="${o.key.application.semester.semester}" disabled>
                                                        </div>

                                                        <div class="input-group mb-3">
                                                            <span class="input-group-text" id="basic-addon1"><i
                                                                    class="bi bi-envelope-fill"></i></span>
                                                            <input type="email" class="form-control" id="companyMail"
                                                                name="companyMail" value="${o.key.companyEmail}"
                                                                disabled>
                                                            <!-- <a href="mailto: ${o.key.companyEmail}">
                                                                                                    ${o.key.companyEmail}</a>  -->


                                                        </div>

                                                        <div class="input-group mb-3">
                                                            <span class="input-group-text" id="basic-addon1"><i
                                                                    class="bi bi-telephone-fill"></i></span>
                                                            <input type="tel" class="form-control" id="companyPhone"
                                                                name="companyPhone" value="${o.key.companyPhone}"
                                                                disabled>
                                                        </div>


                                                        <div class="form-row">
                                                            <div class="col-4 input-group mb-3">
                                                                <span class="input-group-text btn-block"
                                                                    id="basic-addon1">Resources</span>
                                                            </div>
                                                            <div class="col-4 input-group mb-3">
                                                                <a href="${o.key.contractPath}"
                                                                    class="btn btn-outline-info btn-lg btn-block"
                                                                    target="_blank">Contract</a>
                                                            </div>
                                                            <div class="col-4 input-group mb-3">
                                                                <a href="${o.key.letterPath}"
                                                                    class="btn btn-outline-info btn-lg btn-block"
                                                                    target="_blank">Letter</a>
                                                            </div>
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
                                        <!-- Evaluate Modal -->

                                        <div class="modal fade" id="evaluateModal_${o.key.id}" tabindex="-1"
                                            aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">

                                                <div class="modal-content text-center">
                                                    <div class="modal-header"
                                                        style="background: orange; text-align: center; display: unset;">
                                                        <h5 class="modal-title" id="exampleModalLabel">Evaluate
                                                            Detail
                                                        </h5>
                                                    </div>
                                                    <div class="modal-body text-center">

                                                        <div class="mb-3">
                                                            <img src="${o.key.student.account.avatar==null?'/img/default.png':o.key.student.account.avatar}"
                                                                alt="avatar image" class="img-fluid"
                                                                style="height: 150px;" disabled>
                                                        </div>
                                                        <div class="input-group mb-3">
                                                            <span class="input-group-text" id="basic-addon1">Start
                                                                date</span>
                                                            <input type="date" class="form-control" id="startDate"
                                                                value="${o.value.startDate}"
                                                                placeholder="Enter Start Date" name="startDate" readonly
                                                                required>
                                                        </div>
                                                        <div class="input-group mb-3">
                                                            <span class="input-group-text" id="basic-addon1">End
                                                                date</span>
                                                            <input type="date" class="form-control" id="endDate"
                                                                value="${o.value.endDate}" placeholder="Enter End Date"
                                                                name="endDate" readonly required>
                                                        </div>

                                                        <div class="input-group mb-3">
                                                            <span class="input-group-text" id="basic-addon1">Job
                                                                Description</span>

                                                            <textarea class="form-control" id="description"
                                                                placeholder="Enter Description" name="jobDescription"
                                                                readonly required ${o.value.status=="Passed" ||
                                                                o.value.status=="Not Passed" ?"disabled":""}
                                                                value="${o.value.description}">${o.value.description}</textarea>

                                                        </div>

                                                        <div class="form-row">
                                                            <div class="col-9 input-group mb-3">
                                                                <span class="input-group-text"
                                                                    id="basic-addon1">Knowledge</span>
                                                                <textarea class="form-control" id="requirement"
                                                                    placeholder="Enter Knowledge Evaluate"
                                                                    name="knowledge" value="${o.value.knowledge}"
                                                                    readonly required ${o.value.status=="Passed" ||
                                                                    o.value.status=="Not Passed"
                                                                    ?"disabled":""}>${o.value.knowledge}</textarea>
                                                            </div>

                                                            <div class="col-3 input-group mb-3">
                                                                <!-- <select name="point1" class="custom-select" readonly
                                                                    id="grade1" aria-label=".form-select-lg example"
                                                                    value="${o.value.knowledgePoint}" required
                                                                    ${o.value.status=="Passed" ||
                                                                    o.value.status=="Not Passed" ?"disabled":""}>
                                                                    <c:forEach begin="0" end="10" step="1" var="it">
                                                                        <option value="${it}"
                                                                            ${o.value.knowledgePoint==it?"selected":""}>
                                                                            ${it}
                                                                        </option>
                                                                    </c:forEach>
                                                                </select> -->
                                                                <input name="point1" class="form-control" id="grade1"
                                                                    aria-label=".form-select-lg example"
                                                                    value="${o.value.knowledgePoint}" disabled>
                                                                </input>
                                                            </div>
                                                        </div>

                                                        <div class="form-row">
                                                            <div class="col-9 input-group mb-3">
                                                                <span class="input-group-text" id="basic-addon1">Soft
                                                                    skill</span>
                                                                <textarea class="form-control" id="requirement" readonly
                                                                    placeholder="Enter Soft Skill Evaluate"
                                                                    name="softSkill" value="${o.value.softSkill}"
                                                                    required ${o.value.status=="Passed" ||
                                                                    o.value.status=="Not Passed"
                                                                    ?"disabled":""}>${o.value.softSkill}</textarea>
                                                            </div>

                                                            <div class="col-3 input-group mb-3">
                                                                <!-- <select name="point2" class="custom-select"
                                                                    id="grade2" readonly
                                                                    aria-label=".form-select-lg example"
                                                                    value="${o.value.softSkillPoint}"
                                                                    required ${o.value.status=="Passed" || o.value.status == "Not Passed"?"disabled":""}>
                                                                <c:forEach begin="0" end="10" step="1" var="it">
                                                                    <option value="${it}"
                                                                        ${o.value.softSkillPoint==it?"selected":""}>
                                                                            ${it}
                                                                    </option>
                                                                </c:forEach>
                                                            </select> -->
                                                                <input name="point2" class="form-control" id="grade2"
                                                                    aria-label=".form-select-lg example"
                                                                    value="${o.value.softSkillPoint}" disabled>
                                                                </input>
                                                            </div>
                                                        </div>

                                                        <div class="form-row">
                                                            <div class="col-9 input-group mb-3">
                                                                <span class="input-group-text"
                                                                    id="basic-addon1">Attitude</span>
                                                                <textarea class="form-control" id="requirement"
                                                                    placeholder="Enter Attitude Evaluate" readonly
                                                                    name="attitude" value="${o.value.attitude}" required
                                                                    ${o.value.status=="Passed" ||
                                                                    o.value.status=="Not Passed"
                                                                    ?"disabled":""}>${o.value.attitude}</textarea>
                                                            </div>

                                                            <div class="col-3 input-group mb-3">
                                                                <!-- <select name="point3" class="custom-select" id="grade3"
                                                                    aria-label=".form-select-lg example" readonly
                                                                    value="${o.value.attitudePoint}" required
                                                                    ${o.value.status=="Passed" ||
                                                                    o.value.status=="Not Passed" ?"disabled":""}>
                                                                    <c:forEach begin="0" end="10" step="1" var="it">
                                                                        <option value="${it}"
                                                                            ${o.value.attitudePoint.equals(it)?"selected":""}>
                                                                            ${it}
                                                                        </option>
                                                                    </c:forEach>
                                                                </select> -->
                                                                <input name="point3" class="form-control" id="grade3"
                                                                    aria-label=".form-select-lg example"
                                                                    value="${o.value.attitudePoint}" disabled>
                                                                </input>
                                                            </div>
                                                        </div>

                                                        <div class="input-group mb-3">
                                                            <span class="input-group-text"
                                                                id="basic-addon1">Grade</span>
                                                            <input type="number" class="form-control" id="total"
                                                                value="${o.value.grade}" name="total" readonly>
                                                        </div>

                                                    </div>


                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-outline-danger"
                                                            data-dismiss="modal"><i class="bi bi-x-circle"></i>
                                                            Close
                                                        </button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                        <!-- +++++++++++++++++++++++++++++++++++++++++ -->
                                        <!-- +++++++++++++++++++++++++++++++++++++++++++ -->
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