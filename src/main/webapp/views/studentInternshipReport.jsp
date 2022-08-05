<%-- Document : listofstudent Created on : Jun 18, 2022, 8:20:20 PM Author : admin --%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <title>Internship Report</title>
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

            </head>

            <body>
                <%@include file="header.jsp" %>


                    <br />
                    <div class="container">

                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb align-items-center">
                                <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Internship Report</li>
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

                            <br />
                            <div class="container" style="justify-content: center;">
                                <div>
                                    <div class="row">
                                        <div class="col">
                                            <h1 style="color: orange">Internship Report for ${account.fullName}</h1>
                                        </div>
                                    </div>
                                    <br />
                                    <div class="container">

                                        <div class="table-responsive-lg">
                                            <table id="myTable" class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>No.</th>
                                                        <th>Semester</th>
                                                        <th>Company</th>
                                                        <th>Position</th>
                                                        <th>Start date</th>
                                                        <th>End date</th>
                                                        <th>Evaluation Detail</th>
                                                        <th>Grade</th>
                                                        <th>Status</th>
                                                        <%--<th>Verifier</th>--%>
                                                            <%--<th>Action</th>--%>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${processList}" var="o" varStatus="loop">
                                                        <tr>
                                                            <td>${loop.count}</td>
                                                            <td class="text-truncate" style="max-width: 150px;"
                                                                title="${o.application.semester.semester}">
                                                                ${o.application.semester.semester}</td>
                                                            <td class="text-truncate" style="max-width: 150px;"
                                                                title="${o.application.job.company.account.fullName}">
                                                                ${o.application.job.company.account.fullName}</td>
                                                            <td class="text-truncate" style="max-width: 150px;"
                                                                title="${o.application.job.position.position}">
                                                                ${o.application.job.position.position}</td>
                                                            <td>${o.startDate}</td>
                                                            <td>${o.endDate}</td>
                                                            <td>
                                                                <button class="btn btn-outline-info btn-sm"
                                                                    data-toggle="modal"
                                                                    data-target="#evaluateModal_${o.id}">
                                                                    <i class="bi bi-eye"></i> View
                                                                </button>
                                                            </td>
                                                            <td>${o.grade}</td>
                                                            <td>${o.status}</td>
                                                        </tr>
                                                        <!-- Evaluate Modal -->

                                                        <div class="modal fade" id="evaluateModal_${o.id}" tabindex="-1"
                                                            aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog">

                                                                <div class="modal-content text-center">
                                                                    <div class="modal-header"
                                                                        style="background: orange; text-align: center; display: unset;">
                                                                        <h5 class="modal-title" id="exampleModalLabel">
                                                                            Evaluate
                                                                            Detail
                                                                        </h5>
                                                                    </div>
                                                                    <div class="modal-body text-center">

                                                                        <div class="mb-3">
                                                                            <img src="${o.student.account.avatar==null?'/img/default.png':o.student.account.avatar}"
                                                                                alt="avatar image" class="img-fluid"
                                                                                style="height: 150px;" disabled>
                                                                        </div>
                                                                        <div class="input-group mb-3">
                                                                            <span class="input-group-text"
                                                                                id="basic-addon1">Start date</span>
                                                                            <input type="date" class="form-control"
                                                                                id="startDate" value="${o.startDate}"
                                                                                placeholder="Enter Start Date"
                                                                                name="startDate" readonly required>
                                                                        </div>
                                                                        <div class="input-group mb-3">
                                                                            <span class="input-group-text"
                                                                                id="basic-addon1">End date</span>
                                                                            <input type="date" class="form-control"
                                                                                id="endDate" value="${o.endDate}"
                                                                                placeholder="Enter End Date"
                                                                                name="endDate" readonly required>
                                                                        </div>

                                                                        <div class="input-group mb-3">
                                                                            <span class="input-group-text"
                                                                                id="basic-addon1">Job
                                                                                Description</span>

                                                                            <textarea class="form-control"
                                                                                id="description"
                                                                                placeholder="Enter Description"
                                                                                name="jobDescription" readonly required
                                                                                ${o.status=="Passed" ||
                                                                                o.status=="Not Passed" ?"disabled":""}
                                                                                value="${o.description}">${o.description}</textarea>

                                                                        </div>

                                                                        <div class="form-row">
                                                                            <div class="col-9 input-group mb-3">
                                                                                <span class="input-group-text"
                                                                                    id="basic-addon1">Knowledge</span>
                                                                                <textarea class="form-control"
                                                                                    id="requirement"
                                                                                    placeholder="Enter Knowledge Evaluate"
                                                                                    name="knowledge"
                                                                                    value="${o.knowledge}" readonly
                                                                                    required ${o.status=="Passed" ||
                                                                                    o.status=="Not Passed"
                                                                                    ?"disabled":""}>${o.knowledge}</textarea>
                                                                            </div>

                                                                            <div class="col-3 input-group mb-3">
                                                                                <!-- <select name="point1" class="custom-select" readonly
                                                            id="grade1"
                                                            aria-label=".form-select-lg example"
                                                            value="${o.knowledgePoint}"
                                                            required ${o.status=="Passed" || o.status == "Not Passed"?"disabled":""}>
                                                        <c:forEach begin="0" end="10" step="1" var="it">
                                                            <option value="${it}"
                                                                ${o.knowledgePoint==it?"selected":""}>
                                                                    ${it}
                                                            </option>
                                                        </c:forEach>
                                                    </select> -->
                                                                                <input name="point1"
                                                                                    class="form-control" id="grade1"
                                                                                    aria-label=".form-select-lg example"
                                                                                    value="${o.knowledgePoint}"
                                                                                    disabled>

                                                                                </input>
                                                                            </div>
                                                                        </div>

                                                                        <div class="form-row">
                                                                            <div class="col-9 input-group mb-3">
                                                                                <span class="input-group-text"
                                                                                    id="basic-addon1">Soft skill</span>
                                                                                <textarea class="form-control"
                                                                                    id="requirement" readonly
                                                                                    placeholder="Enter Soft Skill Evaluate"
                                                                                    name="softSkill"
                                                                                    value="${o.softSkill}" required
                                                                                    ${o.status=="Passed" ||
                                                                                    o.status=="Not Passed"
                                                                                    ?"disabled":""}>${o.softSkill}</textarea>
                                                                            </div>

                                                                            <div class="col-3 input-group mb-3">
                                                                                <!-- <select name="point2" class="custom-select"
                                                            id="grade2" readonly
                                                            aria-label=".form-select-lg example"
                                                            value="${o.softSkillPoint}"
                                                            required ${o.status=="Passed" || o.status == "Not Passed"?"disabled":""}>
                                                        <c:forEach begin="0" end="10" step="1" var="it">
                                                            <option value="${it}"
                                                                ${o.softSkillPoint==it?"selected":""}>
                                                                    ${it}
                                                            </option>
                                                        </c:forEach>
                                                    </select> -->
                                                                                <input name="point2"
                                                                                    class="form-control" id="grade2"
                                                                                    aria-label=".form-select-lg example"
                                                                                    value="${o.softSkillPoint}"
                                                                                    disabled>
                                                                                </input>
                                                                            </div>
                                                                        </div>

                                                                        <div class="form-row">
                                                                            <div class="col-9 input-group mb-3">
                                                                                <span class="input-group-text"
                                                                                    id="basic-addon1">Attitude</span>
                                                                                <textarea class="form-control"
                                                                                    id="requirement"
                                                                                    placeholder="Enter Attitude Evaluate"
                                                                                    readonly name="attitude"
                                                                                    value="${o.attitude}" required
                                                                                    ${o.status=="Passed" ||
                                                                                    o.status=="Not Passed"
                                                                                    ?"disabled":""}>${o.attitude}</textarea>
                                                                            </div>

                                                                            <div class="col-3 input-group mb-3">
                                                                                <!-- <select name="point3" class="custom-select"
                                                            id="grade3"
                                                            aria-label=".form-select-lg example" readonly
                                                            value="${o.attitudePoint}"
                                                            required ${o.status=="Passed" || o.status == "Not Passed"?"disabled":""}>
                                                        <c:forEach begin="0" end="10" step="1" var="it">
                                                            <option value="${it}"
                                                                ${o.attitudePoint.equals(it)?"selected":""}>
                                                                    ${it}
                                                            </option>
                                                        </c:forEach>
                                                    </select> -->
                                                                                <input name="point3"
                                                                                    class="form-control" id="grade3"
                                                                                    aria-label=".form-select-lg example"
                                                                                    value="${o.attitudePoint}" disabled>
                                                                                </input>
                                                                            </div>
                                                                        </div>

                                                                        <div class="input-group mb-3">
                                                                            <span class="input-group-text"
                                                                                id="basic-addon1">Grade</span>
                                                                            <input type="number" class="form-control"
                                                                                id="total" value="${o.grade}"
                                                                                name="total" readonly>
                                                                        </div>

                                                                    </div>


                                                                    <div class="modal-footer">
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

                                                        <!-- +++++++++++++++++++++++++++++++++++++++++ -->
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br />

                    </div>
                    </div>
                    <jsp:include page="footer.jsp" />
            </body>

            </html>