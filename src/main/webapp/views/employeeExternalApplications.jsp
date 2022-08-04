<%-- Document : listofstudent Created on : Jun 18, 2022, 8:20:20 PM Author : admin --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>External Applications</title>
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
            <li class="breadcrumb-item active" aria-current="page">External Applications
            </li>
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
                    <h1 style="color: orange">List of External Applications</h1>
                </div>
            </div>

            <br/>
            <!-- Modal Filter  -->

            <div class="modal fade" id="filter" tabindex="-1"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <form action="/employee/externalApplications">
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
                                        <option value="-1" selected>Select...</option>
                                        <c:forEach var="o" items="${semesterList}">
                                            <option value="${o.id}"
                                                ${o.id==semesterId?"selected":""}>
                                                    ${o.semester}</option>
                                        </c:forEach>
                                    </select>

                                    <div class="input-group-prepend">
                                        <label class="input-group-text"
                                               for="inputGroupSelect01">Status</label>
                                    </div>
                                    <select class="custom-select" id="inputGroupSelect01"
                                            name="statusValue">
                                        <option value="all" }>Select...</option>
                                        <option value="Waiting" ${statusValue=="Waiting"
                                                ?"selected":""}}>Waiting
                                        </option>
                                        <option value="Accepted" ${statusValue=="Accepted"
                                                ?"selected":""}}>Accepted
                                        </option>
                                        <option value="Denied" ${statusValue=="Denied"
                                                ?"selected":""}}>Denied
                                        </option>
                                        <option value="Interning"
                                                ${statusValue.equals("Interning")?"selected":""}}>
                                            Interning
                                        </option>
                                        <option value="Completed"
                                                ${statusValue.equals("Completed")?"selected":""}}>
                                            Completed
                                        </option>
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

            <!-- ++++++++++++++++++++++++++++++++++++++++++++ -->


            <a href="/employee/writeExternalApplicationFile">
                <button class="btn btn-outline-info mb-3" formaction="<c:url value="
                                                /" />"><i class="bi bi-box-arrow-in-down"></i> Export
                </button>
            </a>

            <button type="button" class="btn btn-outline-info ml-2 mb-3" data-toggle="modal"
                    data-target="#filter" style="float: right;">
                <i class="bi bi-funnel-fill"></i> Filter
            </button>

            <div class="container">
                <div class="table-responsive-lg">
                    <table id="myTable" class="table table-bordered">
                        <thead>
                        <tr>
                            <th>No.</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Company Information</th>
                            <!-- <th>Semester</th> -->
                            <th>Evaluation</th>
                            <th>Status</th>
                            <%--<th>Verifier</th>--%>
                            <th>Operation</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${applyList}" var="o" varStatus="loop">
                            <tr>
                                <td>${loop.count}</td>
                                <td class="text-truncate" style="max-width: 150px;"
                                    title="${o.key.student.studentId}">
                                        ${o.key.student.studentId}</td>
                                <td class="text-truncate" style="max-width: 150px;"
                                    title="${o.key.student.account.fullName}">
                                        ${o.key.student.account.fullName}
                                </td>

                                <td>
                                    <button class="btn btn-outline-info btn-sm"
                                            data-toggle="modal"
                                            data-target="#companyModal_${o.key.id}">
                                        <i class="bi bi-eye"></i> View
                                    </button>
                                </td>
                                <!-- <td class="text-truncate" style="max-width: 150px;"
                                                                    title="${o.key.application.semester.semester}">
                                                                    ${o.key.application.semester.semester}
                                                                </td> -->
                                <td>
                                    <c:if test="${o.key.application.status.equals('Passed') ||
                                                                    o.key.application.status.equals('Completed') ||
                                                                    o.key.application.status.equals('Not Passed') ||
                                                                    o.key.application.status.equals('Interning')}">
                                        <button class="btn btn-outline-info btn-sm"
                                                data-toggle="modal"
                                                data-target="#evaluateModal_${o.key.id}">
                                            <i class="bi bi-eye"></i> Evaluate
                                        </button>
                                    </c:if>
                                </td>
                                <!-- <td class="text-truncate" style="max-width: 50px;"
                                                                    title="${o.key.application.semester.semester}">
                                                                    ${o.key.application.semester.semester}</td> -->

                                <td>${o.key.application.status}</td>
                                <%--<td class="text-truncate" style="max-width: 150px;"
                                    title="${o.key.employee.account.fullName}">
                                        ${o.key.employee.account.fullName}</td>
                                <td>--%>

                                    <button
                                            style="${o.key.application.status=='Waiting' || o.key.application.status=='Denied'?'':'pointer-events: none; background-color: lightgrey'}"
                                            class="btn btn-sm btn-outline-success mt-auto mb-auto"
                                            name="op" value="accept" data-toggle="modal"
                                            data-target="#acceptModal${o.key.id}">
                                        <i class="bi bi-check-circle"></i> Accept
                                    </button>
                                    <!-- denyModal${o.key.id} -->
                                    <button
                                            style="${o.key.application.status=='Processing' || o.key.application.status=='Waiting'?'':'pointer-events: none; background-color: lightgrey'}"
                                            data-toggle="modal"
                                            data-target="#denyModal${o.key.id}"
                                            class="btn btn-sm btn-outline-danger mt-auto mb-auto"
                                            name="op" value="remove">
                                        <i class="bi bi-x-circle"></i> Deny
                                    </button>

                                </td>
                            </tr>

                            <!-- Evaluate Modal -->

                            <div class="modal fade" id="evaluateModal_${o.key.id}"
                                 tabindex="-1" aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">

                                    <div class="modal-content text-center">
                                        <form
                                                action="/employee/updateExternalEvaluate/${o.key.id}">
                                            <div class="modal-header"
                                                 style="background: orange; text-align: center; display: unset;">
                                                <h5 class="modal-title"
                                                    id="exampleModalLabel">Evaluate
                                                    Detail
                                                </h5>
                                            </div>
                                            <div class="modal-body text-center">

                                                <div class="mb-3">
                                                    <img src="${o.key.student.account.avatar==null?'/img/default.png':o.key.student.account.avatar}"
                                                         alt="avatar image"
                                                         class="img-fluid"
                                                         style="height: 150px;" disabled>
                                                </div>
                                                <div class="input-group mb-3">
                                                                                    <span class="input-group-text"
                                                                                          id="basic-addon1">Start
                                                                                        date</span>
                                                    <input type="date"
                                                           class="form-control"
                                                           id="startDate"
                                                           value="${o.value.startDate}"
                                                           placeholder="Enter Start Date"
                                                        ${o.value.status=="Passed" ||
                                                                o.value.status=="Not Passed"
                                                                ?"disabled":""} name="startDate"
                                                           required>
                                                </div>
                                                <div class="input-group mb-3">
                                                                                    <span class="input-group-text"
                                                                                          id="basic-addon1">End
                                                                                        date</span>
                                                    <input type="date"
                                                           class="form-control"
                                                           id="endDate"
                                                           value="${o.value.endDate}"
                                                           placeholder="Enter End Date"
                                                        ${o.value.status=="Passed" ||
                                                                o.value.status=="Not Passed"
                                                                ?"disabled":""} name="endDate"
                                                           required>
                                                </div>

                                                <div class="input-group mb-3">
                                                                                    <span class="input-group-text"
                                                                                          id="basic-addon1">Job
                                                                                        Description</span>

                                                    <textarea class="form-control"
                                                              id="description"
                                                              placeholder="Enter Description"
                                                              name="jobDescription" required
                                                        ${o.value.status=="Passed" ||
                                                                o.value.status=="Not Passed"
                                                                ?"disabled":""}
                                                              value="${o.value.description}">${o.value.description}</textarea>

                                                </div>

                                                <div class="form-row">
                                                    <div class="col-9 input-group mb-3">
                                                                                        <span class="input-group-text"
                                                                                              id="basic-addon1">Knowledge</span>
                                                        <textarea class="form-control"
                                                                  id="requirement"
                                                                  placeholder="Enter Knowledge Evaluate"
                                                                  name="knowledge"
                                                                  value="${o.value.knowledge}"
                                                                  required
                                                            ${o.value.status=="Passed"
                                                                    ||
                                                                    o.value.status=="Not Passed"
                                                                    ?"disabled":""}>${o.value.knowledge}</textarea>
                                                    </div>

                                                    <div class="col-3 input-group mb-3">
                                                        <select name="point1"
                                                                class="custom-select"
                                                                id="grade1"
                                                                aria-label=".form-select-lg example"
                                                                value="${o.value.knowledgePoint}"
                                                                required
                                                            ${o.value.status=="Passed"
                                                                    ||
                                                                    o.value.status=="Not Passed"
                                                                    ?"disabled":""}>
                                                            <c:forEach begin="0"
                                                                       end="10" step="1"
                                                                       var="it">
                                                                <option value="${it}"
                                                                    ${o.value.knowledgePoint==it?"selected":""}>
                                                                        ${it}
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="col-9 input-group mb-3">
                                                                                        <span class="input-group-text"
                                                                                              id="basic-addon1">Soft
                                                                                            skill</span>
                                                        <textarea class="form-control"
                                                                  id="requirement"
                                                                  placeholder="Enter Soft Skill Evaluate"
                                                                  name="softSkill"
                                                                  value="${o.value.softSkill}"
                                                                  required
                                                            ${o.value.status=="Passed"
                                                                    ||
                                                                    o.value.status=="Not Passed"
                                                                    ?"disabled":""}>${o.value.softSkill}</textarea>
                                                    </div>

                                                    <div class="col-3 input-group mb-3">
                                                        <select name="point2"
                                                                class="custom-select"
                                                                id="grade2"
                                                                aria-label=".form-select-lg example"
                                                                value="${o.value.softSkillPoint}"
                                                                required
                                                            ${o.value.status=="Passed"
                                                                    ||
                                                                    o.value.status=="Not Passed"
                                                                    ?"disabled":""}>
                                                            <c:forEach begin="0"
                                                                       end="10" step="1"
                                                                       var="it">
                                                                <option value="${it}"
                                                                    ${o.value.softSkillPoint==it?"selected":""}>
                                                                        ${it}
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="col-9 input-group mb-3">
                                                                                        <span class="input-group-text"
                                                                                              id="basic-addon1">Attitude</span>
                                                        <textarea class="form-control"
                                                                  id="requirement"
                                                                  placeholder="Enter Attitude Evaluate"
                                                                  name="attitude"
                                                                  value="${o.value.attitude}"
                                                                  required
                                                            ${o.value.status=="Passed"
                                                                    ||
                                                                    o.value.status=="Not Passed"
                                                                    ?"disabled":""}>${o.value.attitude}</textarea>
                                                    </div>

                                                    <div class="col-3 input-group mb-3">
                                                        <select name="point3"
                                                                class="custom-select"
                                                                id="grade3"
                                                                aria-label=".form-select-lg example"
                                                                value="${o.value.attitudePoint}"
                                                                required
                                                            ${o.value.status=="Passed"
                                                                    ||
                                                                    o.value.status=="Not Passed"
                                                                    ?"disabled":""}>
                                                            <c:forEach begin="0"
                                                                       end="10" step="1"
                                                                       var="it">
                                                                <option value="${it}"
                                                                    ${o.value.attitudePoint.equals(it)?"selected":""}>
                                                                        ${it}
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="input-group mb-3">
                                                                                    <span class="input-group-text"
                                                                                          id="basic-addon1">Grade</span>
                                                    <input type="number"
                                                           class="form-control" id="total"
                                                           value="${o.value.grade}"
                                                           name="total" disabled>
                                                </div>

                                            </div>


                                            <div class="modal-footer">
                                                <button type="submit"
                                                        class="btn btn-outline-success"
                                                    ${o.value.status=="Passed" ||
                                                            o.value.status=="Not Passed"
                                                            ?"hidden":""} id="import"><i
                                                        class="bi bi-check-circle"></i>
                                                    Save
                                                </button>
                                                <button type="button"
                                                        class="btn btn-outline-danger"
                                                        data-dismiss="modal"><i
                                                        class="bi bi-x-circle"></i>
                                                    Close
                                                </button>
                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </div>

                            <!-- +++++++++++++++++++++++++++++++++++++++++ -->

                            <!--Company Modal -->

                            <div class="modal fade" id="companyModal_${o.key.id}"
                                 tabindex="-1" aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">

                                    <div class="modal-content text-center">
                                        <div class="modal-header"
                                             style="background: orange; text-align: center; display: unset;">
                                            <h5 class="modal-title"
                                                id="exampleModalLabel">
                                                    ${o.key.companyName}
                                            </h5>
                                        </div>
                                        <div class="modal-body text-center">

                                            <div class="input-group mb-3">
                                                                                <span class="input-group-text"
                                                                                      id="basic-addon1"><i
                                                                                        class="fas fa-calendar-alt"></i></span>
                                                <input type="text" class="form-control"
                                                       id="semester" name="semester"
                                                       value="${o.key.application.semester.semester}"
                                                       disabled>
                                            </div>

                                            <div class="input-group mb-3">
                                                                                <span class="input-group-text"
                                                                                      id="basic-addon1"><i
                                                                                        class="bi bi-envelope-fill"></i></span>
                                                <input type="email" class="form-control"
                                                       id="companyMail" name="companyMail"
                                                       value="${o.key.companyEmail}"
                                                       disabled>
                                                <!-- <a href="mailto: ${o.key.companyEmail}">
                                                                                                    ${o.key.companyEmail}</a>  -->


                                            </div>

                                            <div class="input-group mb-3">
                                                                                <span class="input-group-text"
                                                                                      id="basic-addon1"><i
                                                                                        class="bi bi-telephone-fill"></i></span>
                                                <input type="tel" class="form-control"
                                                       id="companyPhone"
                                                       name="companyPhone"
                                                       value="${o.key.companyPhone}"
                                                       disabled>
                                            </div>


                                            <div class="form-row">
                                                <div class="col-4 input-group mb-3">
                                                                                    <span
                                                                                            class="input-group-text btn-block"
                                                                                            id="basic-addon1">Resources</span>
                                                </div>
                                                <div class="col-4 input-group mb-3">
                                                    <a href="${o.key.contractPath}"
                                                       class="btn btn-outline-info btn-lg btn-block" target="_blank">Contract</a>
                                                </div>
                                                <div class="col-4 input-group mb-3">
                                                    <a href="${o.key.letterPath}"
                                                       class="btn btn-outline-info btn-lg btn-block" target="_blank">Letter</a>
                                                </div>
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

                            <!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
                            <!-- Accept Modal -->
                            <div class="modal fade" id="acceptModal${o.key.id}"
                                 tabindex="-1" aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <form
                                            action="verifyExternalApplication/${o.key.id}/Accepted">
                                        <div class="modal-content text-center">
                                            <div class="modal-header"
                                                 style="background: orange; text-align: center; display: unset;">
                                                <h5 class="modal-title"
                                                    id="exampleModalLabel4">
                                                    Accept Form</h5>
                                            </div>
                                            <h4>Are you sure you want to accept this
                                                application</h4>
                                            <div class="modal-footer">
                                                <button type="submit"
                                                        class="btn btn-outline-success btn-sm">
                                                    <i class="bi bi-check-circle"></i>
                                                    Accept
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
                            <div class="modal fade" id="denyModal${o.key.id}"
                                 tabindex="-1" aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <form
                                            action="verifyExternalApplication/${o.key.id}/Denied">
                                        <div class="modal-content text-center">
                                            <div class="modal-header"
                                                 style="background: orange; text-align: center; display: unset;">
                                                <h5 class="modal-title"
                                                    id="exampleModalLabel4">
                                                    Deny Form</h5>
                                            </div>
                                            <h4>Are you sure you want to deny this
                                                application</h4>
                                            <div class="modal-footer">
                                                <button type="submit"
                                                        class="btn btn-outline-danger btn-sm">
                                                    <i class="bi bi-x-circle"></i>
                                                    Deny
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